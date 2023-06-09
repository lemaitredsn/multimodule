package com.example.accounts.data

import com.example.accounts.api.Account
import com.example.accounts.api.AccountLoader
import io.reactivex.Single
import javax.inject.Inject

class AccountTestRepository @Inject constructor(
    private val api: SourceApi
) : AccountLoader {
    override fun getAccounts(): Single<List<Account>> {
        return Single.just(api.loadAccountApi().map {
                Account(it.number, it.amount, getType(it), getCurrency(it))
            })
    }

    private fun getCurrency(account: AccountApi) = when (account.currency) {
        "r" -> Account.Currency.RUB
        "d" -> Account.Currency.DOL
        else -> error("unknown type currency ${account.currency}")
    }

    private fun getType(account: AccountApi) = when (account.type) {
        "cur" -> Account.Type.Current
        "m" -> Account.Type.Main
        else -> error("unknown type ${account.type}")
    }

}