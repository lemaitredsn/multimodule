package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import lemaite.simplepay.flow.SimplePayFlowActivity
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey
import ru.lemaitre.operations.api.OperationDeps
import ru.lemaitre.operations.api.OperationDepsProvider

@Module
object OperationDependenciesModule {

    @Provides
    fun provideOperationDeps(impl: AppComponent): OperationDepsProvider {
        return object : OperationDepsProvider {
            override val activity: Class<*> = SimplePayFlowActivity::class.java
            override val extra: String = SimplePayFlowActivity.EXTRA_ID
        }
    }

    @Provides
    @IntoMap
    @DependenciesKey(OperationDeps::class)
    fun bindOperationDeps(impl: AppComponent): Dependencies = impl
}