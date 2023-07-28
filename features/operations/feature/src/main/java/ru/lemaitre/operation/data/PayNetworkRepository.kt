package ru.lemaitre.operation.data

import io.reactivex.Single
import ru.lemaitre.operation.domain.PayRepository

class PayNetworkRepository: PayRepository {
    override fun execute(amount: String): Single<String> = Single
        .just("Платеж на сумму $amount выполнен успешно")

}