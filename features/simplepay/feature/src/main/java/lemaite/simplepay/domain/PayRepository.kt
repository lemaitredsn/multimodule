package lemaite.simplepay.domain

import io.reactivex.Single

internal interface PayRepository {
    fun execute(amount: String): Single<String>
}