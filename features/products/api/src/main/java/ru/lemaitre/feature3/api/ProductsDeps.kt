package ru.lemaitre.feature3.api

import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.shared.AccountUseCase

interface ProductsDeps : Dependencies {
    val productsDepsProvider: ProductsDepsProvider
}

interface ProductsDepsProvider {
    val accountUseCase: AccountUseCase
}