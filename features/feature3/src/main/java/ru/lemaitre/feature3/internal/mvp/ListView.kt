package ru.lemaitre.feature3.internal.mvp

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ListView : MvpView {
    fun showAccounts(list: List<String>)
}