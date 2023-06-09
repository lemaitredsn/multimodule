package ru.lemaitre.products.mvp.list

import androidx.annotation.DrawableRes

internal data class ProductUiModel(
    val id: String,
    val number: String,
    val amount: String,
    @DrawableRes val icon: Int
)