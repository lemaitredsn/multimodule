package lemaite.simplepay.domain

import javax.inject.Inject

internal class ExecutePayUseCase @Inject constructor(
    private val payRepository: PayRepository
) {

    operator fun invoke(amount: String) = payRepository.execute(amount)
}