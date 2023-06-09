package ru.lemaitre.products.api

import android.content.Context
import com.example.accounts.api.AccountLoader
import ru.lemaitre.common.utils.Dependencies

interface ProductsDeps : Dependencies {
    val productsDepsProvider: ProductsDepsProvider
    val context: Context
}

interface ProductsDepsProvider {
    val accountLoader: AccountLoader
}