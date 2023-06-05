package com.example.accounts.data

import com.example.accounts.api.Account
import com.example.accounts.api.AccountLoader
import javax.inject.Inject

class AccountTestRepository @Inject constructor(
    private val api: SourceApi
) : AccountLoader {
    override fun getAccounts(): List<Account> {
        return api.loadAccountApi()
            .map {
                Account(it.number, it.amount, it.type)
            }
    }
}