package ru.lemaitre.mymultymodule.di

import com.example.accounts.api.AccountLoader
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.account_details.api.AccountDetailsDeps
import ru.lemaitre.account_details.api.AccountDetailsDepsProvider
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey

@Module
object AccountDetailsDependenciesModule {

    @Provides
    fun provideAccountDetailsDeps(impl: AppComponent): AccountDetailsDepsProvider =
        object : AccountDetailsDepsProvider {
            override val accountLoader: AccountLoader = impl.getAccountLoader()
        }


    @Provides
    @IntoMap
    @DependenciesKey(AccountDetailsDeps::class)
    fun bindProductsDeps(impl: AppComponent): Dependencies = impl
}