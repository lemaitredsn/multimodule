package ru.lemaitre.operation.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface OperationFlowView: MvpView {
    fun navigate(screen: OperationFlowRouter)
}