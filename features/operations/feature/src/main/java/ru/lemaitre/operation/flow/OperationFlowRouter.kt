package ru.lemaitre.operation.flow

internal sealed class OperationFlowRouter {
    object Main: OperationFlowRouter()

    object Pay: OperationFlowRouter()
    data class Success(val message: String) : OperationFlowRouter()
}