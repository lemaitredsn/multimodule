package ru.lemaitre.mymultymodule.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.lemaitre.feature3.api.ProductsDeps
import ru.lemaitre.mymultymodule.MainActivity
import ru.lemaitre.shared.AccountUseCase
import javax.inject.Singleton

//@Scope
//annotation class MainActivityScope

@Component(
    modules = [
        ProductsDependenciesModule::class
    ]
)
@Singleton
interface MainActivityComponent : ProductsDeps { //todo ADD operation deps
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    val accountUseCase: AccountUseCase
    // todo нужно сделать навигацию

    fun inject(activity: MainActivity)
}