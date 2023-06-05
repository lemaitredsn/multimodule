package com.example.accounts.api

interface AccountLoader {
    fun getAccounts(): List<Account>
}