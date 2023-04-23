package ru.lemaitre.mymultymodule.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.mymultymodule.MainActivity
import ru.lemaitre.mymultymodule.domain.AccountUseCase
import ru.lemaitre.mymultymodule.feature2.api.Feature2Deps
import javax.inject.Scope

@Scope
annotation class MainActivityScope

@Component(
    modules = [
        Feature2DependenciesModule::class,
    ]
)
@MainActivityScope
interface MainActivityComponent : Feature2Deps {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    val accountUseCase: AccountUseCase

    fun inject(activity: MainActivity)
}