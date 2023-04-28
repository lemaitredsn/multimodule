package ru.lemaitre.mymultymodule.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.feature2.api.Feature2Deps
import ru.lemaitre.mymultymodule.MainActivity
import ru.lemaitre.shared.AccountUseCase
import javax.inject.Scope
import javax.inject.Singleton

//@Scope
//annotation class MainActivityScope

@Component(
    modules = [
        Feature2DependenciesModule::class,
    ]
)
@Singleton
interface MainActivityComponent : Feature2Deps {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    val accountUseCase: AccountUseCase
    // todo нужно сделать навигацию

    fun inject(activity: MainActivity)
}