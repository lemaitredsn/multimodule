package ru.lemaitre.operation.mvp.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.common.utils.ComponentFinder
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.operation.databinding.FragmentPayBinding
import ru.lemaitre.operation.di.OperationComponent

internal class PayFragment: MvpAppCompatFragment(), PayView {

    private val presenter by moxyPresenter {
        ComponentFinder
            .find<ComponentProvider<OperationComponent>>(this)
            .component
            .providePayPresenter()
    }
    private val binding by viewBinding { FragmentPayBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            send.setOnClickListener {
                presenter.onSendClicked(
                    this.entedAmount.text.toString(),
                    this.comment.text.toString()
                )
            }
        }
    }

    override fun showError() {
        Toast.makeText(requireActivity(), "Незаполнена сумма", Toast.LENGTH_SHORT).show()
    }
}