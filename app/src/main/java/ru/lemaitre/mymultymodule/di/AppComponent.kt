package ru.lemaitre.mymultymodule.di

import android.content.Context
import com.example.accounts.api.AccountLoader
import com.example.api.ChatDeps
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.common.utils.ResourceManager
import ru.lemaitre.mymultymodule.MultiModuleApp
import ru.lemaitre.products.api.ProductsDeps
import javax.inject.Singleton


@Component(
    modules = [
        ProductsDependenciesModule::class,
        AccountDepsModule::class,
        AppModule::class
    ]
)
@Singleton
interface AppComponent : ProductsDeps {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun getAccountLoader(): AccountLoader

    fun context(): Context
    fun resourceManager(): ResourceManager
    fun inject(app: MultiModuleApp)
}