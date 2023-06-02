package ru.lemaitre.products.api


interface ProductsDeps : ru.lemaitre.common.utils.Dependencies {
    val productsDepsProvider: ProductsDepsProvider
}

interface ProductsDepsProvider {
}