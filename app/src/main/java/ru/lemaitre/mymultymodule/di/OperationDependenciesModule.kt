package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey
import ru.lemaitre.operations.api.OperationDeps

@Module
object OperationDependenciesModule {

    @Provides
    fun provideOperationDeps(impl: AppComponent): OperationDeps {
        return object : OperationDeps {}
    }

    @Provides
    @IntoMap
    @DependenciesKey(OperationDeps::class)
    fun bindOperationDeps(impl: AppComponent): Dependencies = impl
}