package ru.lemaitre.operation.mvp.pay

import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

internal class PayPresenter @Inject constructor(
    //todo передать какой-
// нибуть получатель счетов установить его может сделать возможность выбора
) : BasePresenter<PayView>() {

    fun onSendClicked(amount: String, comment: String) {
        if (amount.isEmpty()) {
            viewState.showError()
        }
    }
}