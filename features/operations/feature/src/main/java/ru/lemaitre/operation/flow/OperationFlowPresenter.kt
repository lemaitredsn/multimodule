package ru.lemaitre.operation.flow

import android.util.Log
import ru.lemaitre.shared.ui.BasePresenter
import javax.inject.Inject

class OperationFlowPresenter @Inject constructor(
    private val flow: OperationFlow
) : BasePresenter<OperationFlowView>() {

    override fun onFirstViewAttach() {
        flow.navigation()
            .subscribe(
                viewState::navigate,
                ::errorNavigation
            )
            .untilDestroy()
    }

    private fun errorNavigation(e: Throwable) {
        Log.e("TAG", "${e.printStackTrace()}")
    }
}