package lemaite.simplepay.domain

import io.reactivex.Single

interface PayRepository {
    fun execute(amount: String): Single<String>
}