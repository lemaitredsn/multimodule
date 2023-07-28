package lemaite.simplepay.data

import io.reactivex.Single
import lemaite.simplepay.domain.PayRepository

class PayNetworkRepository: PayRepository {
    override fun execute(amount: String): Single<String> = Single
        .just("Платеж на сумму $amount выполнен успешно")

}