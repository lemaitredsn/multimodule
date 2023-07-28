package ru.lemaitre.operation.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.common.utils.findDependencies
import ru.lemaitre.common.utils.scopedComponent
import ru.lemaitre.operation.R
import ru.lemaitre.operation.di.DaggerOperationComponent
import ru.lemaitre.operation.di.OperationComponent
import ru.lemaitre.operation.mvp.operation.OperationFragmentDirections
import ru.lemaitre.operations.api.OperationDeps
import ru.lemaitre.result.SuccessFragmentArgs

internal class OperationFlowFragment : MvpAppCompatFragment(), OperationFlowView,
    ComponentProvider<OperationComponent> {

    override val component: OperationComponent by scopedComponent {
        DaggerOperationComponent
            .factory()
            .create(findDependencies<OperationDeps>())
    }

    private val presenter by moxyPresenter {
        component
            .provideFlowPresenter()
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

        when (screen) {
            OperationFlowRouter.Main -> navController.setGraph(R.navigation.operation_flow_nav_graph)
            OperationFlowRouter.Pay -> navController.navigate(OperationFragmentDirections.toPay())
            is OperationFlowRouter.Success -> navController
                .navigate(
                    ru.lemaitre.result.R.id.success_nav_graph,
                    SuccessFragmentArgs(
                        title = screen.message,
                        descriptions = null,
                        button = null,
                        isAutoClose = true
                    ).toBundle()
                )
        }
    }
}