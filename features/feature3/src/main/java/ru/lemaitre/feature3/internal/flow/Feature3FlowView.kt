package ru.lemaitre.feature3.internal.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface Feature3FlowView: MvpView {
    fun navigate(screen: Feature3Route)
}