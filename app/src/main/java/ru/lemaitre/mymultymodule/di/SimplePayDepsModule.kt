package ru.lemaitre.mymultymodule.di

import android.content.Context
import com.example.accounts.api.AccountLoader
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import lemaitre.simplepay.api.SimplePayDeps
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey
import ru.lemaitre.common.utils.ResourceManager

@Module
class SimplePayDepsModule {

    @Provides
    fun provideSimplePayDeps(impl: AppComponent): SimplePayDeps {
        return object : SimplePayDeps {
            override val resourceManager: ResourceManager = impl.resourceManager
            override val context: Context = impl.context
            override val _accountLoader: AccountLoader = impl.getAccountLoader()
        }
    }

    @Provides
    @IntoMap
    @DependenciesKey(SimplePayDeps::class)
    fun bindSimplePayDeps(impl: AppComponent): Dependencies = impl

}