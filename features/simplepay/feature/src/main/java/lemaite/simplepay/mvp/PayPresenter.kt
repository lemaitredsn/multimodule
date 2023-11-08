package lemaite.simplepay.mvp

import android.content.ContentResolver
import android.content.Context
import android.util.Log
import com.example.accounts.api.AccountLoader
import io.reactivex.android.schedulers.AndroidSchedulers
import lemaite.simplepay.domain.ExecutePayUseCase
import lemaite.simplepay.flow.SimplePayFlow
import ru.lemaitre.architecture.BasePresenter
import ru.lemaitre.common.utils.ResourceManager
import javax.inject.Inject

class PayPresenter @Inject constructor(
    //todo передать какой-
// нибуть получатель счетов установить его может сделать возможность выбора
    private val payUseCase: ExecutePayUseCase,
    private val flow: SimplePayFlow,
    private val resourceManager: ResourceManager,
    private val contentResolver: ContentResolver,
    private val accountLoader: AccountLoader
) : BasePresenter<PayView>() {

    override fun onFirstViewAttach() {
        accountLoader.getAccounts()
            .subscribe({
                Log.e("TAG", "${it.joinToString()}")
            },{
                Log.e("TAG", "$it")
            })

    }

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