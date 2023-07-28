package ru.lemaitre.operation.mvp.operation

import ru.lemaitre.architecture.BasePresenter
import ru.lemaitre.operation.flow.OperationFlow
import ru.lemaitre.operations.api.OperationDeps
import javax.inject.Inject

internal class OperationPresenter @Inject constructor(
    private val flow: OperationFlow,
    private val deps: OperationDeps
): BasePresenter<OperationView>() {

    fun onPayClicked() {
        flow.toPay(deps.depsProvider.activity, deps.depsProvider.extra)
    }
}