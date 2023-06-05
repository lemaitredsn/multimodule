package ru.lemaitre.products.api

import com.example.accounts.api.AccountLoader
import ru.lemaitre.common.utils.Dependencies

interface ProductsDeps : Dependencies {
    val productsDepsProvider: ProductsDepsProvider
}

interface ProductsDepsProvider {
    val accountLoader: AccountLoader
}