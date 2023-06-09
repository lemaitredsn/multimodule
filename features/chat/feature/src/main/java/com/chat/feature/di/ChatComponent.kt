package com.chat.feature.di

import com.chat.feature.flow.ChatFlowPresenter
import com.example.api.ChatDeps
import dagger.Component
import javax.inject.Scope

@ChatScope
@Component(dependencies = [ChatDeps::class])
interface ChatComponent {
    @Component.Factory
    interface Factory {
        fun create(deps: ChatDeps) : ChatComponent
    }

    fun provideFlowPresenter(): ChatFlowPresenter
}

@Scope
annotation class ChatScope