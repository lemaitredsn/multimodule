package ru.lemaitre.products.mvp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.common.utils.ComponentFinder
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.products.R
import ru.lemaitre.products.di.ProductsComponent

internal class ListFragment : MvpAppCompatFragment(), ListView {

    private val presenter by moxyPresenter {
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
        view.findViewById<Button>(R.id.chat).setOnClickListener {
            presenter.onChatClicked()
        }

        view.findViewById<RecyclerView>(R.id.listAccount).adapter = ProductsAdapter {
            presenter.onProductItemClicked(it.id)
        }

    }

    override fun showAccounts(list: List<ProductUiModel>) {
        (view?.findViewById<RecyclerView>(R.id.listAccount)?.adapter as? ProductsAdapter)?.submitList(
            list
        )
    }
}