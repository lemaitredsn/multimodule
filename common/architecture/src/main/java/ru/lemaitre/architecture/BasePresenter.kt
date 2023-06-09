package ru.lemaitre.architecture

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<T : MvpView> : MvpPresenter<T>() {
    private val container = CompositeDisposable()

    override fun onDestroy() {
        container.clear()
        super.onDestroy()
    }

    protected fun Disposable.untilDestroy() {
        container.add(this)
    }
}
