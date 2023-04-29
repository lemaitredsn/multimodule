package ru.lemaitre.feature3.internal.mvp

import android.util.Log
import io.reactivex.Single
import ru.lemaitre.feature3.api.Feature3Deps
import ru.lemaitre.feature3.internal.flow.Feature3Flow
import ru.lemaitre.shared.ui.BasePresenter
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val flow: Feature3Flow,
    deps: Feature3Deps
) : BasePresenter<ListView>() {

    private val accountUseCase = deps.feature3Provider.accountUseCase

    override fun onFirstViewAttach() {
        Single.just(accountUseCase.getAccounts())
            .subscribe({
                viewState.showAccounts(it)
            }, {
                Log.e("TAG", "error load account ${it.localizedMessage}")
            })
            .untilDestroy()
    }
}