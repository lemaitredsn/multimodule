package lemaite.simplepay.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface SimplePayFlowView : MvpView {
    fun navigate(screen: SimplePayFlowRoute)

}