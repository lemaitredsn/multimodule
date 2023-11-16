package lemaite.simplepay.di

import android.content.Context
import lemaitre.simplepay.api.SimplePayDeps
import dagger.Component
import lemaite.simplepay.flow.SimplePayFlowPresenter
import lemaite.simplepay.mvp.PayPresenter
import javax.inject.Scope

@SimplePayScope
@Component(dependencies = [SimplePayDeps::class], modules = [SimplePayModule::class])
internal interface SimplePayComponent {

    val simplePayDeps: SimplePayDeps

    @Component.Factory
    interface Factory {
        fun create(deps: SimplePayDeps): SimplePayComponent
    }

    fun provideFlowPresenter(): SimplePayFlowPresenter
    fun providePayPresenter(): PayPresenter
}

@Scope
annotation class SimplePayScope