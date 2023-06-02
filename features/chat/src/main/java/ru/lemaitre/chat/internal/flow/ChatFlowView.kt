package ru.lemaitre.chat.internal.flow

import moxy.MvpView
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface ChatFlowView: MvpView {
    fun navigate(screen: ChatRoute)
}