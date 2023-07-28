package lemaite.simplepay.di

import lemaitre.simplepay.api.SimplePayDeps
import dagger.Component
import lemaite.simplepay.flow.SimplePayFlowPresenter
import lemaite.simplepay.mvp.PayPresenter
import javax.inject.Scope

@SimplePayScope
@Component(dependencies = [SimplePayDeps::class], modules = [SimplePayModule::class])
interface SimplePayComponent {

    @Component.Factory
    interface Factory {
        fun create(deps: SimplePayDeps): SimplePayComponent
    }

    fun provideFlowPresenter(): SimplePayFlowPresenter
    fun providePayPresenter(): PayPresenter
}

@Scope
annotation class SimplePayScope