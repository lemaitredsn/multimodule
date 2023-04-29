package ru.lemaitre.shared.ui

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<T : MvpView> : MvpPresenter<T>() {
    private val container = CompositeDisposable()

    override fun destroyView(view: T) {
        container.clear()
        super.destroyView(view)
    }

    protected fun Disposable.untilDestroy() {
        container.add(this)
    }
}
