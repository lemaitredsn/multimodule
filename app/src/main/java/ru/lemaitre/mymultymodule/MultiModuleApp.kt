package ru.lemaitre.mymultymodule

import android.app.Application
import ru.lemaitre.common.utils.DepsMap
import ru.lemaitre.common.utils.HasDependencies
import ru.lemaitre.mymultymodule.di.DaggerAppComponent
import javax.inject.Inject

class MultiModuleApp : Application(), HasDependencies {

    @Inject
    override lateinit var depsMap: DepsMap

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }
}