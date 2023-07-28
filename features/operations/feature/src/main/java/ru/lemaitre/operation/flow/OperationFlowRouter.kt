package ru.lemaitre.operation.flow

internal sealed class OperationFlowRouter {
    object Main: OperationFlowRouter()

    data class Pay(val activity: Class<*>, val id: String): OperationFlowRouter()
    data class Success(val message: String) : OperationFlowRouter()
}