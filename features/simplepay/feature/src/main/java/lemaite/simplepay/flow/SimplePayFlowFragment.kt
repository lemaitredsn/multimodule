package lemaite.simplepay.flow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import lemaitre.simplepay.api.SimplePayDeps
import lemaite.simplepay.R
import lemaite.simplepay.databinding.FragmentFlowPayBinding
import lemaite.simplepay.di.DaggerSimplePayComponent
import lemaite.simplepay.di.SimplePayComponent
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.common.utils.findDependencies
import ru.lemaitre.common.utils.scopedComponent

internal class SimplePayFlowFragment: MvpAppCompatFragment(), SimplePayFlowView, ComponentProvider<SimplePayComponent> {

    override val component: SimplePayComponent by scopedComponent {
        val s = DaggerSimplePayComponent
            .factory()
            .create(findDependencies<SimplePayDeps>())
        Log.e("TAG", "$s")
        s
    }

    private val binding by viewBinding { FragmentFlowPayBinding.inflate(layoutInflater) }

    private val presenter by moxyPresenter {
        component
            .provideFlowPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

//fixme исправить ошибку
    override fun navigate(screen: SimplePayFlowRoute) {
        val navController = findNavController()
    when(screen) {
        is SimplePayFlowRoute.Main -> navController.setGraph(R.navigation.simple_pay_nav_graph)
    }

    }
}