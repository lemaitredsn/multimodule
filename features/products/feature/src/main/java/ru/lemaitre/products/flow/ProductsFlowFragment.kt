package ru.lemaitre.products.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.fragment.NavHostFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaite.common.navigation.navigate
import ru.lemaitre.common.utils.findDependencies
import ru.lemaitre.common.utils.scopedComponent
import ru.lemaitre.products.api.ProductsDeps
import ru.lemaitre.products.R
import ru.lemaitre.products.di.DaggerProductsComponent
import ru.lemaitre.products.di.ProductsComponent

class ProductsFlowFragment : MvpAppCompatFragment(), ProductsFlowView,
    ru.lemaitre.common.utils.ComponentProvider<ProductsComponent> {

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
            is ProductsRoute.Success -> TODO()
            ProductsRoute.Chat -> navigate(
                ru.lemaite.common.navigation.NavCommand(
                    ru.lemaite.common.navigation.NavCommands.DeepLink(
                        "chatbank://chat".toUri(),
                        true,
                        false
                    )
                )
            )
        }
    }
}