package com.chat.feature.flow

import android.util.Log
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

internal class ChatFlowPresenter @Inject constructor(
    private val flow: ChatFlow
): BasePresenter<ChatFlowView>() {

    override fun onFirstViewAttach() {
        flow.navigation
            .subscribe(
                viewState::navigate,
                { Log.e("TAG", "error ${it.printStackTrace()}") }
            )
            .untilDestroy()
    }
}