package ru.lemaitre.shared

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class AccountUseCase @Inject constructor() {

    fun getAccountNumber() = "number ${Random.nextInt()}"

    fun getAccounts() = listOf(
        "4080 1234 1234 1234",
        "4080 1234 1234 1235",
        "4080 1234 1234 1236",
        "4080 1234 1234 1237",
        "4080 1234 1234 1238",
        "4080 1234 1234 1239",
        "4080 1234 1234 1240",
        "4080 1234 1234 1241",
        "4080 1234 1234 1242",
        "4080 1234 1234 1243",
        "4080 1234 1234 1244",
        "4080 1234 1234 1245",
    )
}