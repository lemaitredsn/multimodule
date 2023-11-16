package ru.lemaitre.mymultymodule.di

import android.content.Context
import com.example.accounts.api.AccountLoader
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import lemaitre.simplepay.api.SimpleDepsProvider
import lemaitre.simplepay.api.SimplePayDeps
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey
import ru.lemaitre.common.utils.ResourceManager

@Module
class SimplePayDepsModule {

    @Provides
    fun provideSimpleDepsProvider(impl: SimplePayDeps) : SimpleDepsProvider {
        return impl.simpleDepsProvider
    }

    @Provides
    fun provideSimplePayDeps(impl: AppComponent): SimplePayDeps {
        return object : SimplePayDeps {
            override val simpleDepsProvider: SimpleDepsProvider = object : SimpleDepsProvider {
                override val accountLoader: AccountLoader = impl.getAccountLoader()
                override val context: Context = impl.context()
                override val resourceManager: ResourceManager = impl.resourceManager()
            }
        }
    }

    @Provides
    @IntoMap
    @DependenciesKey(SimplePayDeps::class)
    fun bindSimplePayDeps(impl: AppComponent): Dependencies = impl

}