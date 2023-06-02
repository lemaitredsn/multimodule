package ru.lemaitre.common.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

object ComponentFinder {

    /**
     * Traverses parent fragments, activity and application in search of given class.
     * Throws IllegalArgument exception if it fails to find one.
     * Must be called after onAttach().
     */
    inline fun <reified T : Any> find(fragment: Fragment): T {
        return find(T::class.java, fragment)
    }

    @JvmStatic
    fun <T : Any> find(clazz: Class<T>, fragment: Fragment): T {
        var parentFragment: Fragment? = fragment
        while (true) {
            parentFragment = parentFragment?.parentFragment ?: break
            if (parentFragment instanceOf clazz) {
                return parentFragment as T
            }
        }
        val activity = fragment.activity
        if (activity instanceOf clazz) {
            return activity as T
        }
        val application = activity?.application
        if (application instanceOf clazz) {
            return application as T
        }
        throw IllegalArgumentException(
            String.format("No ${clazz.simpleName} was found for %s", fragment.javaClass.canonicalName)
        )
    }

    private infix fun Any?.instanceOf(clazz: Class<*>) = clazz.isInstance(this)
}

interface ComponentProvider<T> {
    val component: T
}

private class ScopedComponentProperty<T>(
    private val storeOwner: ViewModelStoreOwner,
    private val componentProvider: () -> T
) : Lazy<T> {

    private var cached: T? = null

    override val value: T
        get() {
            val component = cached
            if (component != null) return component
            val viewModels = ViewModelProvider(storeOwner, object : ViewModelProvider.Factory {
                override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                    return ScopedComponentHolder(componentProvider()) as VM
                }
            })
            val componentHolder = viewModels.get(ScopedComponentHolder::class.java)
            return (componentHolder.component as T).also { cached = it }
        }

    override fun isInitialized() = cached != null
}

fun <T> ViewModelStoreOwner.scopedComponent(
    componentProvider: () -> T
): Lazy<T> {
    return ScopedComponentProperty(this, componentProvider)
}

private class ScopedComponentHolder<T> constructor(val component: T) : ViewModel()