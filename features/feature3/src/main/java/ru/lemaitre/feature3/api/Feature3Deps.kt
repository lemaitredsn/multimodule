package ru.lemaitre.feature3.api

import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.shared.AccountUseCase

interface Feature3Deps : Dependencies {
    val feature3Provider: Feature3Provider
}

interface Feature3Provider {
    val accountUseCase: AccountUseCase
}