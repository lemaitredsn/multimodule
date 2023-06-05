package ru.lemaitre.products.mvp.list

import android.util.Log
import com.example.accounts.api.AccountLoader
import io.reactivex.Single
import ru.lemaitre.products.api.ProductsDeps
import ru.lemaitre.products.flow.ProductsFlow
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val flow: ProductsFlow,
    deps: ProductsDeps
) : BasePresenter<ListView>() {

    private val accountLoader = deps.productsDepsProvider.accountLoader

    override fun onFirstViewAttach() {
        Single.just(accountLoader.getAccounts())
            .subscribe({
                viewState.showAccounts(it.map { it.number })
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