package ru.lemaitre.mymultymodule.feature2.api

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.lemaitre.mymultymodule.R
import ru.lemaitre.mymultymodule.core.findDependencies
import ru.lemaitre.mymultymodule.feature2.internal.di.DaggerFeature2Component
import javax.inject.Inject

class Feature2Fragment: Fragment() {

//    @Inject
//    internal lateinit var featureFragmentProvider: FeatureFragmentProvider //почему то inject несработал
    internal lateinit var featureFragmentProvider: FeatureFragmentProvider

    override fun onAttach(context: Context) {
        super.onAttach(context)

        featureFragmentProvider = DaggerFeature2Component.factory()
            .create(findDependencies<Feature2Deps>())
            .provider()

        Log.e("TAG", "Feature2Fragment findDeps ${findDependencies<Feature2Deps>()}")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = view.findViewById<TextView>(R.id.title)

            title.setOnClickListener {
                val number = featureFragmentProvider.accountUseCase.getAccountNumber()
                title.text = number
            }
    }
}