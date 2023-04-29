package ru.lemaitre.feature3.internal.mvp.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.core.ComponentFinder
import ru.lemaitre.core.ComponentProvider
import ru.lemaitre.feature3.R
import ru.lemaitre.feature3.internal.di.Feature3Component

internal class ListFragment : MvpAppCompatFragment(), ListView {

    private val presenter by moxyPresenter { //fixme переделать
        ComponentFinder
            .find<ComponentProvider<Feature3Component>>(this)
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

    override fun showAccounts(list: List<String>) {
        view?.findViewById<TextView>(R.id.listAccount)?.text = list.joinToString("\n")
    }
}