package ru.lemaitre.operation.mvp.pay

import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.architecture.BasePresenter
import ru.lemaitre.operation.domain.ExecutePayUseCase
import ru.lemaitre.operation.flow.OperationFlow
import javax.inject.Inject

internal class PayPresenter @Inject constructor(
    //todo передать какой-
// нибуть получатель счетов установить его может сделать возможность выбора
    private val payUseCase: ExecutePayUseCase,
    private val flow: OperationFlow
) : BasePresenter<PayView>() {

    fun onSendClicked(amount: String, comment: String) {
        if (amount.isEmpty()) {
            viewState.showError()
        }else{
            payUseCase(amount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  flow.success(message = it)
                },{
                    //todo
                })
                .untilDestroy()
        }

    }
}