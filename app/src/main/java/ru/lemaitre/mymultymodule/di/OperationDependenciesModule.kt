package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.core_dagger.DependenciesKey
import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.operations.api.OperationDeps

@Module
object OperationDependenciesModule {

    @Provides
    fun provideOperationDeps(impl: MainActivityComponent): OperationDeps {
        return object : OperationDeps {}
    }

    @Provides
    @IntoMap
    @DependenciesKey(OperationDeps::class)
    fun bindOperationDeps(impl: MainActivityComponent): Dependencies = impl
}