package lemaite.simplepay.di

import dagger.Module
import dagger.Provides
import lemaite.simplepay.data.PayNetworkRepository
import lemaite.simplepay.domain.PayRepository
import lemaite.simplepay.flow.SimplePayFlow

@Module
class SimplePayModule {

    @Provides
    @SimplePayScope
    fun provideFlow() = SimplePayFlow()

    @Provides
    fun provideRepository(): PayRepository = PayNetworkRepository()
}