package lemaite.simplepay.di

import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides
import lemaite.simplepay.data.PayNetworkRepository
import lemaite.simplepay.domain.PayRepository
import lemaite.simplepay.flow.SimplePayFlow
import lemaitre.simplepay.api.SimpleDepsProvider
import lemaitre.simplepay.api.SimplePayDeps

@Module
internal class SimplePayModule {

    @Provides
    fun provideContext(simplePayDeps: SimplePayDeps): Context = simplePayDeps.simpleDepsProvider.context

    @Provides
    fun provideResourceManager(simplePayDeps: SimplePayDeps) = simplePayDeps.simpleDepsProvider.resourceManager

    @Provides
    fun provideAccountLoader(simplePayDeps: SimplePayDeps) = simplePayDeps.simpleDepsProvider.accountLoader

    @Provides
    @SimplePayScope
    fun provideFlow() = SimplePayFlow()

    @Provides
    fun provideRepository(): PayRepository = PayNetworkRepository()

    @Provides
    fun provideContentResolver(context: Context): ContentResolver = context.contentResolver
}