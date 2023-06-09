package ru.lemaitre.account_details.mvp

import com.example.accounts.api.Account
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AccountDetailsView: MvpView {
    fun setAccount(account: Account)
    fun setHistory(models: List<HistoryUiModel>)
}