package ru.lemaitre.shared.navigation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import ru.lemaitre.mymultymodule.core.allParents

interface NavigationProvider {
    fun launch(navCommand: NavCommand)
}

data class NavCommand(
    val target: NavCommands,
    var args: Bundle? = null,
    val navOptions: NavOptions? = null
)

sealed class NavCommands {
    data class Browser(val url: String) : NavCommands()
    data class DeepLink(
        val url: Uri,
        val isModal: Boolean,
        val isSingleTop: Boolean = false
    ) : NavCommands()
}

fun Fragment.navigate(navCommand: NavCommand) {
    getNavigator.launch(navCommand)
}

val Fragment.getNavigator: NavigationProvider
    get() = allParents
        .mapNotNull { it as? NavigationProvider }
        .firstOrNull()
        ?: throw IllegalStateException("No navigation provider")
