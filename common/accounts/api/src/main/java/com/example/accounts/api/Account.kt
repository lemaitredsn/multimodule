package com.example.accounts.api

data class Account(
    val number: String,
    val amount: Double,
    val type: Type,
    val currency: Currency
) {

    enum class Type {
        Current,
        Main
    }

    enum class Currency {
        RUB, DOL
    }
}
