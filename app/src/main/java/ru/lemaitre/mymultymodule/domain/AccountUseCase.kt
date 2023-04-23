package ru.lemaitre.mymultymodule.domain

import ru.lemaitre.mymultymodule.di.MainActivityScope
import javax.inject.Inject
import kotlin.random.Random

@MainActivityScope
class AccountUseCase @Inject constructor() {

    fun getAccountNumber() = "number ${Random.nextInt()}"
}