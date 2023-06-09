package ru.lemaitre.account_details.di

import dagger.Component
import ru.lemaitre.account_details.api.AccountDetailsDeps
import ru.lemaitre.account_details.flow.AccountDetailsFlowPresenter
import ru.lemaitre.account_details.mvp.AccountDetailsPresenter
import javax.inject.Scope

@AccountDetailsScope
@Component(dependencies = [AccountDetailsDeps::class])
interface AccountDetailsComponent {

    @Component.Factory
    interface Factory {
        fun create(deps: AccountDetailsDeps): AccountDetailsComponent
    }

    fun provideFlowPresenter(): AccountDetailsFlowPresenter.Factory
    fun provideDetailsPresenter(): AccountDetailsPresenter
}

@Scope
annotation class AccountDetailsScope