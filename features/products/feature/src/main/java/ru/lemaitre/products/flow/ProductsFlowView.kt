package ru.lemaitre.products.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface ProductsFlowView: MvpView {
    fun navigate(screen: ProductsRoute)
}