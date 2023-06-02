package ru.lemaitre.operation.flow

import android.util.Log
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

class OperationFlowPresenter @Inject constructor(
    private val flow: OperationFlow
) : ru.lemaitre.architecture.BasePresenter<OperationFlowView>() {

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