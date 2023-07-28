package ru.lemaitre.operation.mvp.operation

import ru.lemaitre.architecture.BasePresenter
import ru.lemaitre.operation.flow.OperationFlow
import javax.inject.Inject

internal class OperationPresenter @Inject constructor(
    private val flow: OperationFlow
): BasePresenter<OperationView>() {

    fun onPayClicked() {
        flow.toPay()
    }
}