package ru.lemaitre.chat.internal.di

import dagger.Component
import ru.lemaitre.chat.internal.flow.ChatFlowPresenter

@ChatScope
@Component()
internal interface ChatComponent {

    fun provideChatFlowPresenter(): ChatFlowPresenter
}