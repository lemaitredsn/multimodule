package ru.lemaitre.mymultymodule.di

import com.example.accounts.api.AccountLoader
import com.example.accounts.di.DaggerAccountComponent

object AccountFactory {
    fun create(/*deps: AccountDependencies*/): AccountLoader =
        DaggerAccountComponent.factory().create().impl
}