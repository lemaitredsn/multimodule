package lemaite.simplepay.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface SimplePayFlowView : MvpView {
    fun navigate(screen: SimplePayFlowRoute)

}