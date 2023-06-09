package com.example.accounts.data

import javax.inject.Inject

class SourceApi @Inject constructor() {
    fun loadAccountApi(): List<AccountApi> =
        listOf(
            AccountApi("1234123413241231", "cur", 1.1, "r"),
            AccountApi("1234123413241232", "cur", 22.1, "d"),
            AccountApi("1234123413241233", "cur", 33.1, "d"),
            AccountApi("1234123413241234", "m", 444.1, "r"),
            AccountApi("1234123413241235", "m", 5555.1, "d"),
        )
}