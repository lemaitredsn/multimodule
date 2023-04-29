package ru.lemaitre.feature3.internal.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.core.ComponentProvider
import ru.lemaitre.core.scopedComponent
import ru.lemaitre.feature3.R
import ru.lemaitre.feature3.api.Feature3Deps
import ru.lemaitre.feature3.internal.di.DaggerFeature3Component
import ru.lemaitre.feature3.internal.di.Feature3Component
import ru.lemaitre.mymultymodule.core.findDependencies

internal class Feature3FlowFragment : MvpAppCompatFragment(), Feature3FlowView,
    ComponentProvider<Feature3Component> {

    override val component: Feature3Component by scopedComponent {
        DaggerFeature3Component
            .factory()
            .create(findDependencies<Feature3Deps>())
    }

    private val presenter by moxyPresenter {
        component.provideFlowPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_feature_3_flow, container, false)
    }

    override fun navigate(screen: Feature3Route) {
        val navController =
            (childFragmentManager.findFragmentById(R.id.feature_3_container) as NavHostFragment)
                .navController
        when (screen) {
            Feature3Route.List -> navController.setGraph(R.navigation.feature_3_flow_nav_graph)
        }
    }
}