package ru.lemaitre.mymultymodule.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import lemaitre.simplepay.api.SimplePayDeps
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey

@Module
class SimplePayDepsModule {

    @Provides
    fun provideSimplePayDeps(): SimplePayDeps {
        return object : SimplePayDeps {}
    }

    @Provides
    @IntoMap
    @DependenciesKey(SimplePayDeps::class)
    fun bindSimplePayDeps(impl: AppComponent): Dependencies = impl

}