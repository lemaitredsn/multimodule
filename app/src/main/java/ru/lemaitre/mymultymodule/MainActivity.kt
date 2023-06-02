package ru.lemaitre.mymultymodule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.lemaitre.mymultymodule.core.DepsMap
import ru.lemaitre.mymultymodule.core.HasDependencies
import ru.lemaitre.mymultymodule.di.DaggerMainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasDependencies {

    @Inject
    override lateinit var depsMap: DepsMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        DaggerMainActivityComponent
            .factory()
            .create(this)
            .inject(this)

        Log.e("TAG", "deps $depsMap")

        setContentView(R.layout.activity_main)

    }
}