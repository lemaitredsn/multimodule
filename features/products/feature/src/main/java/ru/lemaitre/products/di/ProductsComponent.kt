package ru.lemaitre.products.di

import dagger.Component
import ru.lemaitre.feature3.api.ProductsDeps
import ru.lemaitre.products.flow.ProductsFlowPresenter
import ru.lemaitre.products.mvp.list.ListPresenter

@ProductsScope
@Component(dependencies = [ProductsDeps::class])
internal interface ProductsComponent {

    @Component.Factory
    interface Factory {
        fun create(deps: ProductsDeps): ProductsComponent
    }

    fun provideFlowPresenter(): ProductsFlowPresenter
    fun provideListPresenter(): ListPresenter
}