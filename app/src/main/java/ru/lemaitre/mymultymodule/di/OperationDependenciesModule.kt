package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.common.utils.DependenciesKey
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.operations.api.OperationDeps

@Module
object OperationDependenciesModule {

    @Provides
    fun provideOperationDeps(impl: MainActivityComponent): OperationDeps {
        return object : OperationDeps {}
    }

    @Provides
    @IntoMap
    @ru.lemaitre.common.utils.DependenciesKey(OperationDeps::class)
    fun bindOperationDeps(impl: MainActivityComponent): ru.lemaitre.common.utils.Dependencies = impl
}