package ru.lemaitre.account_details.flow

import android.util.Log
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.architecture.BasePresenter

class AccountDetailsFlowPresenter @AssistedInject constructor(
    @Assisted private val accountId: String,
    private val flow: AccountDetailsFlow
) : BasePresenter<AccountDetailsFlowView>() {

    init {
        flow.accountId = accountId
    }

    override fun onFirstViewAttach() {
        flow.navigationIn
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(viewState::navigation) {
                Log.e("TAG", "error ${it.printStackTrace()}")
            }
            .untilDestroy()
    }

    @AssistedFactory
    interface Factory{
        fun create(accountId: String): AccountDetailsFlowPresenter
    }
}