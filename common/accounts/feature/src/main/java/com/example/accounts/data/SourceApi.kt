package com.example.accounts.data

import javax.inject.Inject

class SourceApi @Inject constructor() {
    fun loadAccountApi(): List<AccountApi> =
        listOf(
            AccountApi("1234 1234 1324 1231", "текущий", 1.1),
            AccountApi("1234 1234 1324 1232", "расчетный", 22.1),
            AccountApi("1234 1234 1324 1233", "новый", 33.1),
            AccountApi("1234 1234 1324 1234", "любимый", 444.1),
            AccountApi("1234 1234 1324 1235", "ведущий", 5555.1),
        )
}