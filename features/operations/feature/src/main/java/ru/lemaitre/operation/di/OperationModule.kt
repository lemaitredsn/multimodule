package ru.lemaitre.operation.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.operation.data.PayNetworkRepository
import ru.lemaitre.operation.domain.PayRepository
import ru.lemaitre.operation.flow.OperationFlow

@Module
internal class OperationModule {

    @Provides
    @OperationScope
    fun provideFlow() = OperationFlow()

    @Provides
    fun provideRepository(): PayRepository = PayNetworkRepository()
}