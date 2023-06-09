package ru.lemaitre.account_details.api

import com.example.accounts.api.AccountLoader
import ru.lemaitre.common.utils.Dependencies

interface AccountDetailsDeps: Dependencies {
    val accountDetailsDepsProvider: AccountDetailsDepsProvider
}

interface AccountDetailsDepsProvider {
    val accountLoader: AccountLoader
}

