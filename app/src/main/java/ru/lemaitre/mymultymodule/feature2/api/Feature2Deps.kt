package ru.lemaitre.mymultymodule.feature2.api

import androidx.fragment.app.Fragment
import ru.lemaitre.mymultymodule.core.Dependencies
import ru.lemaitre.mymultymodule.domain.AccountUseCase

interface Feature2Deps: Dependencies {
    val featureFragmentProvider: FeatureFragmentProvider
}

interface FeatureFragmentProvider {
    val featFragment: Fragment
    val accountUseCase: AccountUseCase
}