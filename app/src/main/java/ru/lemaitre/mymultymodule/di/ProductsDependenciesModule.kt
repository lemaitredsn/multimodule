package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.products.api.ProductsDeps
import ru.lemaitre.products.api.ProductsDepsProvider

@Module
object ProductsDependenciesModule {

    @Provides
    fun provideProductsDeps(impl: MainActivityComponent): ProductsDepsProvider {
        return object : ProductsDepsProvider {
        }
    }

    @Provides
    @IntoMap
    @ru.lemaitre.common.utils.DependenciesKey(ProductsDeps::class)
    fun  bindProductsDeps(impl: MainActivityComponent): ru.lemaitre.common.utils.Dependencies = impl
}