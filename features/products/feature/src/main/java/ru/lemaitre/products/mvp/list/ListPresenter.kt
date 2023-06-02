package ru.lemaitre.products.mvp.list

import android.util.Log
import io.reactivex.Single
import ru.lemaitre.feature3.api.ProductsDeps
import ru.lemaitre.products.flow.ProductsFlow
import ru.lemaitre.shared.ui.BasePresenter
import javax.inject.Inject

internal class ListPresenter @Inject constructor(
    private val flow: ProductsFlow,
    deps: ProductsDeps
) : BasePresenter<ListView>() {

    private val accountUseCase = deps.productsDepsProvider.accountUseCase

    override fun onFirstViewAttach() {
        Single.just(accountUseCase.getAccounts())
            .subscribe({
                viewState.showAccounts(it)
            }, {
                Log.e("TAG", "error load account ${it.localizedMessage}")
            })
            .untilDestroy()
    }

    fun onViewClicked() {
        flow.toSuccessResult(
            "Успешный успех",
            "Эта операция выполнена максимально правильно",
            "Закрыть!"
        )
    }

    fun onChatClicked() {
        flow.toChat()
    }
}