package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.core_dagger.DependenciesKey
import ru.lemaitre.feature3.api.ProductsDeps
import ru.lemaitre.feature3.api.ProductsDepsProvider
import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.shared.AccountUseCase

@Module
object ProductsDependenciesModule {

    @Provides
    fun provideProductsDeps(impl: MainActivityComponent): ProductsDepsProvider {
        return object : ProductsDepsProvider {
            override val accountUseCase: AccountUseCase = impl.accountUseCase
        }
    }

    @Provides
    @IntoMap
    @DependenciesKey(ProductsDeps::class)
    fun  bindProductsDeps(impl: MainActivityComponent): Dependencies = impl
}