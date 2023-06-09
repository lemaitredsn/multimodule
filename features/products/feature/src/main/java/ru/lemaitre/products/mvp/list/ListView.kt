package ru.lemaitre.products.mvp.list

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
internal interface ListView : MvpView {
    fun showAccounts(list: List<ProductUiModel>)
}