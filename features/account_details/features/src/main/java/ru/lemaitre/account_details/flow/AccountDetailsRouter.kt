package ru.lemaitre.account_details.flow

sealed class AccountDetailsRouter {
    object Main: AccountDetailsRouter()

    data class SimplePay(val accountId: String) : AccountDetailsRouter()
}
