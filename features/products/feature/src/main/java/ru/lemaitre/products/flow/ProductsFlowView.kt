package ru.lemaitre.products.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface ProductsFlowView: MvpView {
    fun navigate(screen: ProductsRoute)
}