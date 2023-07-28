package ru.lemaitre.operation.flow

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

internal class OperationFlowPresenter @Inject constructor(
    private val flow: OperationFlow
) : BasePresenter<OperationFlowView>() {

    override fun onFirstViewAttach() {
        flow.navigation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it ->
                    viewState.navigate(it)
                },
                ::errorNavigation
            )
            .untilDestroy()
    }

    private fun errorNavigation(e: Throwable) {
        Log.e("TAG", "${e.printStackTrace()}")
    }
}