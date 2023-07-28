package ru.lemaitre.account_details.mvp

import android.util.Log
import ru.lemaitre.account_details.api.AccountDetailsDeps
import ru.lemaitre.account_details.domain.HistoryInteractor
import ru.lemaitre.account_details.flow.AccountDetailsFlow
import ru.lemaitre.account_details.mvp.HistoryUiMapper.toUi
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

class AccountDetailsPresenter @Inject constructor(
    private val flow: AccountDetailsFlow,
    private val deps: AccountDetailsDeps,
    private val historyInteractor: HistoryInteractor
) : BasePresenter<AccountDetailsView>() {

    val account = deps.accountDetailsDepsProvider.accountLoader

    override fun onFirstViewAttach() {
        account.getAccounts()
            .map { accounts ->
                accounts.first { it.number == flow.accountId }
            }
            .doOnSuccess {
                viewState.setAccount(it)
            }
            .flatMap {
                historyInteractor.loadHistory()
            }
            .subscribe(
                { history ->
                    viewState.setHistory(history.map { it.toUi() })
                }, {
                    Log.e("TAG", "${it.printStackTrace()}")
                }
            )
            .untilDestroy()
    }

    fun onCreatePayClicked() {
        flow.toSimplePay(flow.accountId)
    }
}