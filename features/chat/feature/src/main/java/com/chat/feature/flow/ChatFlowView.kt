package com.chat.feature.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface ChatFlowView: MvpView {
    fun navigate(screen: ChatRoute)
}
