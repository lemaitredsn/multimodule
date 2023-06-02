package ru.lemaitre.products.mvp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.core.ComponentFinder
import ru.lemaitre.core.ComponentProvider
import ru.lemaitre.products.R
import ru.lemaitre.products.di.ProductsComponent

internal class ListFragment : MvpAppCompatFragment(), ListView {

    private val presenter by moxyPresenter { //fixme переделать
        ComponentFinder
            .find<ComponentProvider<ProductsComponent>>(this)
            .component
            .provideListPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.listAccount).setOnClickListener {
            presenter.onViewClicked()
        }

        view.findViewById<Button>(R.id.chat).setOnClickListener {
            presenter.onChatClicked()
        }

    }

    override fun showAccounts(list: List<String>) {
        view?.findViewById<TextView>(R.id.listAccount)?.text = list.joinToString("\n")
    }
}