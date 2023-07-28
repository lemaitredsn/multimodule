package lemaite.simplepay.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import lemaite.simplepay.domain.ExecutePayUseCase
import lemaite.simplepay.flow.SimplePayFlow
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

class PayPresenter @Inject constructor(
    //todo передать какой-
// нибуть получатель счетов установить его может сделать возможность выбора
    private val payUseCase: ExecutePayUseCase,
    private val flow: SimplePayFlow
) : BasePresenter<PayView>() {

    fun onSendClicked(amount: String, comment: String) {
        if (amount.isEmpty()) {
            viewState.showError()
        }else{
            payUseCase(amount)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                  flow.success(message = it)
                },{
//                    todo
                })
                .untilDestroy()
        }

    }
}