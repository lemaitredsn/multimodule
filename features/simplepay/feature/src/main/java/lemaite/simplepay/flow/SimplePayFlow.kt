package lemaite.simplepay.flow

import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

internal class SimplePayFlow {
    private val navigationIn =
        PublishSubject.create<SimplePayFlowRoute>()

    fun navigation() = navigationIn
}