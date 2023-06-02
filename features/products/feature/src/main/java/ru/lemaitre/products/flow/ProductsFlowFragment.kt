package ru.lemaitre.products.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.NavHostFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.core.ComponentProvider
import ru.lemaitre.core.scopedComponent
import ru.lemaitre.feature3.api.ProductsDeps
import ru.lemaitre.products.di.ProductsComponent
import ru.lemaitre.mymultymodule.core.findDependencies
import ru.lemaitre.products.R
import ru.lemaitre.products.di.DaggerProductsComponent
import ru.lemaitre.shared.navigation.NavCommand
import ru.lemaitre.shared.navigation.NavCommands
import ru.lemaitre.shared.navigation.navigate
import ru.lemaitre.shared.ui.result.SuccessFragmentArgs

internal class ProductsFlowFragment : MvpAppCompatFragment(), ProductsFlowView,
    ComponentProvider<ProductsComponent> {

    override val component: ProductsComponent by scopedComponent {
        DaggerProductsComponent
            .factory()
            .create(findDependencies<ProductsDeps>())
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

    override fun navigate(screen: ProductsRoute) {
        val navController =
            (childFragmentManager.findFragmentById(R.id.feature_3_container) as NavHostFragment)
                .navController
        when (screen) {
            ProductsRoute.List -> navController.setGraph(R.navigation.feature_3_flow_nav_graph)
            is ProductsRoute.Success -> navController.navigate(
                ru.lemaitre.shared.R.id.success_nav_graph,
                SuccessFragmentArgs(
                    title = screen.title,
                    descriptions = screen.descriptions,
                    button = screen.button,
                    isAutoClose = true
                ).toBundle()
            )
            ProductsRoute.Chat -> navigate(
                NavCommand(
                    NavCommands.DeepLink(
                        "chatbank://chat".toUri(),
                        true,
                        false
                    )
                )
            )
        }
    }
}