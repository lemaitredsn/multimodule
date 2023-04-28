package ru.lemaitre.feature3.internal.di

import dagger.Component
import ru.lemaitre.feature3.internal.flow.Feature3FlowPresenter

@Feature3Scope
@Component()
interface Feature3Component {

    fun provideFlowPresenter(): Feature3FlowPresenter
}