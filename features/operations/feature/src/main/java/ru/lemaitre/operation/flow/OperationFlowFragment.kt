package ru.lemaitre.operation.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.common.utils.scopedComponent
import ru.lemaitre.common.utils.findDependencies
import ru.lemaitre.operation.R
import ru.lemaitre.operation.di.DaggerOperationComponent
import ru.lemaitre.operation.di.OperationComponent
import ru.lemaitre.operations.api.OperationDeps

internal class OperationFlowFragment: Fragment(), OperationFlowView,
    ComponentProvider<OperationComponent> {

    override val component: OperationComponent by scopedComponent {
        DaggerOperationComponent
            .factory()
            .create(findDependencies<OperationDeps>())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_operation_flow, container, false)
    }

    override fun navigate(screen: OperationFlowRouter) {
        val navController =
            (childFragmentManager.findFragmentById(R.id.operation_container) as NavHostFragment)
                .navController

        when(screen) {
            OperationFlowRouter.Main -> navController.setGraph(R.navigation.operation_flow_nav_graph)
        }
    }
}