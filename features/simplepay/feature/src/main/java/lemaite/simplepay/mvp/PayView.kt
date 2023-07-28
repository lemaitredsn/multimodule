package lemaite.simplepay.mvp

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution

@AddToEndSingle
interface PayView: MvpView {

    @OneExecution
    fun showError()
}