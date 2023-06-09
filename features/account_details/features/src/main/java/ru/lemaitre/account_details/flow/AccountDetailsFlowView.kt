package ru.lemaitre.account_details.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface AccountDetailsFlowView : MvpView {
    fun navigation(screen: AccountDetailsRouter)
}