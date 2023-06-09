package ru.lemaitre.products.mvp.list

import android.util.Log
import io.reactivex.Single
import ru.lemaitre.architecture.BasePresenter
import ru.lemaitre.products.api.ProductsDeps
import ru.lemaitre.products.flow.ProductsFlow
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val flow: ProductsFlow,
    private val mapper: ProductsUiMapper,
    deps: ProductsDeps
) : BasePresenter<ListView>() {

    private val accountLoader = deps.productsDepsProvider.accountLoader

    override fun onFirstViewAttach() {
        Single.just(accountLoader.getAccounts())
            .subscribe({ accounts ->
                viewState.showAccounts(accounts.map { mapper.map(it) })
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