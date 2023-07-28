package ru.lemaitre.operation.flow

import io.reactivex.subjects.BehaviorSubject
import ru.lemaitre.operation.di.OperationScope
import javax.inject.Inject

internal class OperationFlow {

    private val navigationIn = BehaviorSubject.createDefault<OperationFlowRouter>(OperationFlowRouter.Main)

    fun navigation() = navigationIn
    fun toPay() = navigationIn.onNext(OperationFlowRouter.Pay)
    fun success(message: String) {
        navigationIn.onNext(OperationFlowRouter.Success(message))
    }
}