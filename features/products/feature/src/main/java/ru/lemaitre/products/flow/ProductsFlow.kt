package ru.lemaitre.products.flow

import io.reactivex.subjects.BehaviorSubject
import ru.lemaitre.products.di.ProductsScope
import javax.inject.Inject

@ProductsScope
class ProductsFlow @Inject constructor() {

    private val navigationIn =
        BehaviorSubject.createDefault<ProductsRoute>(ProductsRoute.List)

    fun navigation() = navigationIn

    fun toSuccessResult(title: String, descriptions: String, button: String) =
        navigationIn.onNext(ProductsRoute.Success(title, descriptions, button))

    fun toChat() = navigationIn.onNext(ProductsRoute.Chat)
}