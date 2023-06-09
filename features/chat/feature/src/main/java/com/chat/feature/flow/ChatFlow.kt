package com.chat.feature.flow

import com.chat.feature.di.ChatScope
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

@ChatScope
class ChatFlow @Inject constructor() {

    val navigation = BehaviorSubject.createDefault(ChatRoute.Main)
}
