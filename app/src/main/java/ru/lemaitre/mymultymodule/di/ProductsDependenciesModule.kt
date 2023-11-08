package ru.lemaitre.mymultymodule.di

import com.example.accounts.api.AccountLoader
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.account_details.flow.AccountDetailsFlowActivity
import ru.lemaitre.common.utils.Dependencies
import ru.lemaitre.common.utils.DependenciesKey
import ru.lemaitre.mymultymodule.R
import ru.lemaitre.products.api.ProductsDeps
import ru.lemaitre.products.api.ProductsDepsProvider

@Module
object ProductsDependenciesModule {

    @Provides
    fun provideProductsDeps(impl: AppComponent): ProductsDepsProvider =
        object : ProductsDepsProvider {
            override val accountLoader: AccountLoader = impl.getAccountLoader()
            override val activityDetails: Class<*> = AccountDetailsFlowActivity::class.java
            override val extra: String = AccountDetailsFlowActivity.EXTRA_ID
            override val selectAccountId: Int = com.example.select_account.R.navigation.select_account_flow_nav_graph
        }

    @Provides
    @IntoMap
    @DependenciesKey(ProductsDeps::class)
    fun bindProductsDeps(impl: AppComponent): Dependencies = impl
}