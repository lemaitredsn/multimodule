package ru.lemaitre.mymultymodule.di

import android.content.Context
import com.example.accounts.api.AccountLoader
import com.example.api.ChatDeps
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.account_details.api.AccountDetailsDeps
import ru.lemaitre.common.utils.ResourceManager
import ru.lemaitre.mymultymodule.MultiModuleApp
import ru.lemaitre.operations.api.OperationDeps
import ru.lemaitre.products.api.ProductsDeps
import javax.inject.Singleton


@Component(
    modules = [
        AccountDepsModule::class,
        AppModule::class,
        AccountDetailsDependenciesModule::class,
        ProductsDependenciesModule::class,
        OperationDependenciesModule::class
    ]
)
@Singleton
interface AppComponent : ProductsDeps, AccountDetailsDeps, OperationDeps {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun getAccountLoader(): AccountLoader

    fun context(): Context
    fun resourceManager(): ResourceManager
    fun inject(app: MultiModuleApp)
}