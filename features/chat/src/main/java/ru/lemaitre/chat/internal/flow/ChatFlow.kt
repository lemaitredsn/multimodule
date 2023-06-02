package ru.lemaitre.chat.internal.flow

import io.reactivex.subjects.BehaviorSubject
import ru.lemaitre.chat.internal.di.ChatScope
import javax.inject.Inject

@ChatScope
internal class ChatFlow @Inject constructor() {
    private val navigationIn =
        BehaviorSubject.createDefault<ChatRoute>(ChatRoute.Chat)

    fun navigation() = navigationIn
}