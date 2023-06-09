package ru.lemaitre.account_details.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.accounts.api.Account
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.account_details.databinding.FragmentAccountDetailsBinding
import ru.lemaitre.account_details.di.AccountDetailsComponent
import ru.lemaitre.common.utils.ComponentFinder
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.common.utils.typedAdapter

class AccountDetailsFragment : MvpAppCompatFragment(), AccountDetailsView {

    private val presenter by moxyPresenter {
        ComponentFinder
            .find<ComponentProvider<AccountDetailsComponent>>(this)
            .component
            .provideDetailsPresenter()
    }

    private val binding by viewBinding { FragmentAccountDetailsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.history.adapter = HistoryAdapter()

    }

    override fun setAccount(account: Account) {
        with(binding) {
            amount.text = account.amount.toString()
            number.text = account.number
        }
    }

    override fun setHistory(models: List<HistoryUiModel>) {
        binding.history.typedAdapter<HistoryAdapter>().submitList(models)
    }
}