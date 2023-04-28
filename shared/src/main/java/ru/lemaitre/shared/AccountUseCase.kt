package ru.lemaitre.shared

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class AccountUseCase @Inject constructor() {

    fun getAccountNumber() = "number ${Random.nextInt()}"
}