package ru.lemaitre.feature2.internal.di

import dagger.Component
import ru.lemaitre.feature2.api.Feature2Deps
import ru.lemaitre.feature2.api.Feature2Fragment

@Component(dependencies = [Feature2Deps::class])
interface Feature2Component {
    @Component.Factory
    interface Factory {
        fun create(deps: Feature2Deps): Feature2Component
    }

    fun inject(fragment: Feature2Fragment)
}