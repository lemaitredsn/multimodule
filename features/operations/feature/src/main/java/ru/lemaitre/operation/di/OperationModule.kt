package ru.lemaitre.operation.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.operation.flow.OperationFlow

@Module
internal class OperationModule {

    @Provides
    @OperationScope
    fun provideFlow() = OperationFlow()
}