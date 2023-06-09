package com.example.accounts.api

import io.reactivex.Single

interface AccountLoader {
    fun getAccounts(): Single<List<Account>>
}