package ru.lemaitre.mymultymodule.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.lemaitre.core_dagger.DependenciesKey
import ru.lemaitre.mymultymodule.BlankFragment
import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.shared.AccountUseCase
import javax.inject.Singleton

@Module
object Feature2DependenciesModule {

    @Provides
    @Singleton
    fun otherFeaturesFragmentProvider(impl: MainActivityComponent): ru.lemaitre.feature2.api.FeatureFragmentProvider =
        object : ru.lemaitre.feature2.api.FeatureFragmentProvider {
            override val featFragment: Fragment = BlankFragment()
            override val accountUseCase: AccountUseCase = impl.accountUseCase
        }

    @Provides
    @IntoMap
    @DependenciesKey(ru.lemaitre.feature2.api.Feature2Deps::class)
    fun bindFeature2Deps(impl: MainActivityComponent): Dependencies = impl
}