package ru.lemaitre.products.api

import android.content.Context
import androidx.annotation.NavigationRes
import com.example.accounts.api.AccountLoader
import ru.lemaitre.common.utils.Dependencies

interface ProductsDeps : Dependencies {
    val productsDepsProvider: ProductsDepsProvider
    val context: Context
}

interface ProductsDepsProvider {
    val accountLoader: AccountLoader
    val activityDetails: Class<*>
    val extra: String
    val selectAccountId: Int
}