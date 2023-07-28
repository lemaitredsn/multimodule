package ru.lemaitre.operation.mvp.operation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.common.utils.ComponentFinder
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.operation.databinding.FragmentOperationBinding
import ru.lemaitre.operation.di.OperationComponent

internal class OperationFragment: MvpAppCompatFragment(), OperationView {

    private val presenter by moxyPresenter {
        ComponentFinder
            .find<ComponentProvider<OperationComponent>>(this)
            .component
            .provideOperationPresenter()
    }

    private val binding by viewBinding { FragmentOperationBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            pay.setOnClickListener {
                presenter.onPayClicked()
            }
        }
    }

}