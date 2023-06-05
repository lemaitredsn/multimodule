package ru.lemaitre.products.mvp.list

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ListView : MvpView {
    fun showAccounts(list: List<String>)
}