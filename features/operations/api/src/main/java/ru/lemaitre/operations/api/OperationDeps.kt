package ru.lemaitre.operations.api

import ru.lemaitre.common.utils.Dependencies

interface OperationDeps : Dependencies {
    val depsProvider: OperationDepsProvider
}

interface OperationDepsProvider {
    val activity: Class<*>
    val extra: String
}