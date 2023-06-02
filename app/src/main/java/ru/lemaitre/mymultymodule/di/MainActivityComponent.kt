package ru.lemaitre.mymultymodule.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.products.api.ProductsDeps
import ru.lemaitre.mymultymodule.MainActivity
import javax.inject.Singleton

//@Scope
//annotation class MainActivityScope

@Component(
    modules = [
        ProductsDependenciesModule::class,
    ]
)
@Singleton
interface MainActivityComponent : ProductsDeps { //todo ADD operation deps
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }
    val context: Context
    // todo нужно сделать навигацию

    fun inject(activity: MainActivity)
}