package ru.lemaitre.account_details.flow

import io.reactivex.subjects.PublishSubject
import ru.lemaitre.account_details.di.AccountDetailsScope
import javax.inject.Inject

@AccountDetailsScope
class AccountDetailsFlow @Inject constructor() {
    var accountId: String = ""

    val navigationIn = PublishSubject.create<AccountDetailsRouter>()
    fun toSimplePay(accountId: String) = navigationIn.onNext(AccountDetailsRouter.SimplePay(accountId))
}