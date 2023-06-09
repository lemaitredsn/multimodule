package ru.lemaitre.products.mvp.list

import com.example.accounts.api.Account
import ru.lemaitre.common.utils.ResourceManager
import ru.lemaitre.uikit.R
import javax.inject.Inject

class ProductsUiMapper @Inject constructor(
    val resourceManager: ResourceManager
) {

    fun map(account: Account): ProductUiModel =
        ProductUiModel(
            id = account.number,
            number = account.number,
            amount = "${account.amount} ${account.currency}",
            icon = getIcon(account)
        )

    private fun getIcon(account: Account) = when (account.currency) {
        Account.Currency.RUB -> R.drawable.ic_100
        Account.Currency.DOL -> R.drawable.ic_dollar
    }
}