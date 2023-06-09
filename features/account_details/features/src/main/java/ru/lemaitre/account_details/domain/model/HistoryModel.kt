package ru.lemaitre.account_details.domain.model

data class HistoryModel(
    val data: String,
    val operation: OperationType,
    val amount: String
) {
    enum class OperationType{
        TOP_UP,
        REMOVAL
    }
}