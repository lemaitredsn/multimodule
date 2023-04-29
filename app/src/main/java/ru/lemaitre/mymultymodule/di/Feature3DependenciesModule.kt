package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.core_dagger.DependenciesKey
import ru.lemaitre.feature3.api.Feature3Deps
import ru.lemaitre.feature3.api.Feature3Provider
import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.shared.AccountUseCase

@Module
object Feature3DependenciesModule {

    @Provides
    fun provideF3Deps(impl: MainActivityComponent): Feature3Provider {
        return object : Feature3Provider {
            override val accountUseCase: AccountUseCase = impl.accountUseCase
        }
    }

    @Provides
    @IntoMap
    @DependenciesKey(Feature3Deps::class)
    fun  bindF3Deps(impl: MainActivityComponent): Dependencies = impl
}