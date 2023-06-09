package ru.lemaitre.account_details.data

import io.reactivex.Single
import ru.lemaitre.account_details.domain.model.HistoryModel
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val api: HistoryApi
) {
    fun loadHistory(): Single<List<HistoryModel>> {
        return api.loadHistory()
            .map {
                it.map {
                    HistoryModel(
                        data = it.data,
                        operation = getType(it),
                        amount = it.amount
                    )
                }
            }
    }

    private fun getType(history: HistoryModelApi): HistoryModel.OperationType {
        return when (history.operationType) {
            "p" -> HistoryModel.OperationType.TOP_UP
            "s" -> HistoryModel.OperationType.REMOVAL
            else -> error("unknown type")
        }
    }
}

