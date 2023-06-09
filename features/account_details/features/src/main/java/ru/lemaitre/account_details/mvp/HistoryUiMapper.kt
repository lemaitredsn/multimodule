package ru.lemaitre.account_details.mvp

import ru.lemaitre.account_details.R
import ru.lemaitre.account_details.domain.model.HistoryModel

object HistoryUiMapper {

    fun HistoryModel.toUi() = HistoryUiModel(
        id = this.data,
        icon = getIcon(this.operation),
        title = getTitle(this.operation),
        amount = amount
    )

    private fun getIcon(operationType: HistoryModel.OperationType): Int {
        return when (operationType) {
            HistoryModel.OperationType.TOP_UP -> R.drawable.baseline_arrow_upward_24
            HistoryModel.OperationType.REMOVAL -> R.drawable.baseline_arrow_downward_24
        }
    }

    private fun getTitle(operationType: HistoryModel.OperationType): String {
        return when(operationType) {
            HistoryModel.OperationType.TOP_UP -> "Пополнение"
            HistoryModel.OperationType.REMOVAL -> "Снятие"
        }
    }
}