package ru.lemaitre.chat.internal.flow

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

internal class ChatFlowPresenter @Inject constructor(
    private val flow: ChatFlow
) : BasePresenter<ChatFlowView>() {

    override fun onFirstViewAttach() {
        flow.navigation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.navigate(it)
            }, {
                Log.e("TAG", "crash ${it.localizedMessage}")
            })
            .untilDestroy()
    }

}