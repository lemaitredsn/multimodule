package ru.lemaitre.mymultymodule.feature2.internal.di

import androidx.fragment.app.Fragment
import dagger.Component
import ru.lemaitre.mymultymodule.feature2.api.Feature2Deps
import ru.lemaitre.mymultymodule.feature2.api.FeatureFragmentProvider

@Component(dependencies = [Feature2Deps::class])
interface Feature2Component {
    @Component.Factory
    interface Factory {
        fun create(deps: Feature2Deps): Feature2Component
    }

    fun provider() : FeatureFragmentProvider

    fun inject(fragment: Fragment)
}