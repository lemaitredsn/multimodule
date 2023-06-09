package ru.lemaitre.operation.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface OperationFlowView: MvpView {
    fun navigate(screen: OperationFlowRouter)
}