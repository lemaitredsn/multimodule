package ru.lemaitre.operation.di

import dagger.Component
import ru.lemaitre.operation.flow.OperationFlowPresenter
import ru.lemaitre.operation.mvp.operation.OperationPresenter
import ru.lemaitre.operation.mvp.pay.PayPresenter
import ru.lemaitre.operations.api.OperationDeps
import javax.inject.Scope

@OperationScope
@Component(dependencies = [OperationDeps::class], modules = [OperationModule::class])
internal interface OperationComponent {

    @Component.Factory
    interface Factory {
        fun create(deps: OperationDeps): OperationComponent
    }

    fun provideFlowPresenter(): OperationFlowPresenter
    fun provideOperationPresenter(): OperationPresenter
    fun providePayPresenter(): PayPresenter
}

@Scope
annotation class OperationScope