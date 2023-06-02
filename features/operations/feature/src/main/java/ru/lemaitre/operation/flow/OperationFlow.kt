package ru.lemaitre.operation.flow

import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class OperationFlow @Inject constructor() {

    private val navigationIn = BehaviorSubject.createDefault(OperationFlowRouter.Main)

    fun navigation() = navigationIn
}