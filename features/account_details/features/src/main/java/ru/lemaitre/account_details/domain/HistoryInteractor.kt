package ru.lemaitre.account_details.domain

import ru.lemaitre.account_details.data.HistoryRepository
import javax.inject.Inject

class HistoryInteractor @Inject constructor(private val historyRepository: HistoryRepository) {

    fun loadHistory() = historyRepository.loadHistory()
}