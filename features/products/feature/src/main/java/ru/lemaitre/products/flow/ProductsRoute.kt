package ru.lemaitre.products.flow

internal sealed class ProductsRoute {
    object List: ProductsRoute()
    data class Success(val title: String, val descriptions: String, val button: String): ProductsRoute()
    object Chat : ProductsRoute()
}