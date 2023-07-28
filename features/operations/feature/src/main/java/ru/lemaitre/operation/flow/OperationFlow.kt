package ru.lemaitre.operation.flow

import io.reactivex.subjects.BehaviorSubject

internal class OperationFlow {

    private val navigationIn = BehaviorSubject.createDefault<OperationFlowRouter>(OperationFlowRouter.Main)

    fun navigation() = navigationIn
    fun toPay(activity: Class<*>, id: String) = navigationIn.onNext(OperationFlowRouter.Pay(activity, id))
    fun success(message: String) {
        navigationIn.onNext(OperationFlowRouter.Success(message))
    }
}