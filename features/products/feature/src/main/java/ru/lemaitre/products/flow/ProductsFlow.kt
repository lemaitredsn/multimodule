package ru.lemaitre.products.flow

import androidx.annotation.NavigationRes
import io.reactivex.subjects.BehaviorSubject
import ru.lemaitre.products.di.ProductsScope
import javax.inject.Inject

@ProductsScope
internal class ProductsFlow @Inject constructor() {

    private val navigationIn =
        BehaviorSubject.createDefault<ProductsRoute>(ProductsRoute.List)

    fun navigation() = navigationIn

    fun toSuccessResult(title: String, descriptions: String, button: String) =
        navigationIn.onNext(ProductsRoute.Success(title, descriptions, button))

    fun toChat() = navigationIn.onNext(ProductsRoute.Chat)
    fun toAccountDetails(id: String, activityDetails: Class<*>, extra: String) =
        navigationIn.onNext(ProductsRoute.AccountDetails(id, activityDetails, extra))

    fun toSelectAccount(@NavigationRes id: Int) {
        navigationIn.onNext(ProductsRoute.AccountSelect(id))
    }
}