package com.example.accounts.di

import com.example.accounts.data.AccountTestRepository
import dagger.Component

@Component
interface AccountComponent {

    @Component.Factory
    interface Factory {

        fun create(/*deps: AccountDependencies if need*/): AccountComponent
    }

    val impl: AccountTestRepository
}