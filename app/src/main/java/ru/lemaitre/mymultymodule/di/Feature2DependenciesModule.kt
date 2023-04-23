package ru.lemaitre.mymultymodule.di

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.mymultymodule.BlankFragment
import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.mymultymodule.core_dagger.DependenciesKey
import ru.lemaitre.mymultymodule.domain.AccountUseCase
import ru.lemaitre.mymultymodule.feature2.api.Feature2Deps
import ru.lemaitre.mymultymodule.feature2.api.FeatureFragmentProvider

@Module
object Feature2DependenciesModule {

    @Provides
    @MainActivityScope
    fun otherFeaturesFragmentProvider(impl: MainActivityComponent): FeatureFragmentProvider =
        object : FeatureFragmentProvider {
            override val featFragment: Fragment = BlankFragment()
            override val accountUseCase: AccountUseCase = impl.accountUseCase
        }

    @Provides
    @IntoMap
    @DependenciesKey(Feature2Deps::class)
    fun bindFeature2Deps(impl: MainActivityComponent): Dependencies = impl
}