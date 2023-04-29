package ru.lemaitre.feature3.internal.di

import dagger.Component
import ru.lemaitre.feature3.api.Feature3Deps
import ru.lemaitre.feature3.internal.flow.Feature3FlowPresenter
import ru.lemaitre.feature3.internal.mvp.ListPresenter

@Feature3Scope
@Component(dependencies = [Feature3Deps::class])
interface Feature3Component {

    @Component.Factory
    interface Factory {
        fun create(deps: Feature3Deps): Feature3Component
    }

    fun provideFlowPresenter(): Feature3FlowPresenter
    fun provideListPresenter(): ListPresenter
}