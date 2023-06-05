package ru.lemaitre.mymultymodule.di

import android.content.Context
import com.example.accounts.api.AccountLoader
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.mymultymodule.MultiModuleApp
import ru.lemaitre.products.api.ProductsDeps
import javax.inject.Singleton


@Component(
    modules = [
        ProductsDependenciesModule::class,
        AccountDepsModule::class
    ]
)
@Singleton
interface AppComponent : ProductsDeps {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun getAccountLoader(): AccountLoader
    fun inject(app: MultiModuleApp)
}