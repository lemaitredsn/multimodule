package ru.lemaitre.account_details.flow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaite.common.navigation.NavCommand
import ru.lemaite.common.navigation.NavCommands
import ru.lemaite.common.navigation.navigate
import ru.lemaitre.account_details.R
import ru.lemaitre.account_details.api.AccountDetailsDeps
import ru.lemaitre.account_details.di.AccountDetailsComponent
import ru.lemaitre.account_details.di.DaggerAccountDetailsComponent
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.common.utils.findDependencies
import ru.lemaitre.common.utils.scopedComponent

class AccountDetailsFlowFragment : MvpAppCompatFragment(), AccountDetailsFlowView,
    ComponentProvider<AccountDetailsComponent> {

    override val component: AccountDetailsComponent by scopedComponent {
        DaggerAccountDetailsComponent
            .factory()
            .create(findDependencies<AccountDetailsDeps>())
    }

    private val presenter by moxyPresenter {
        component
            .provideFlowPresenter()
            .create(requireActivity().intent.getStringExtra(AccountDetailsFlowActivity.EXTRA_ID)!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = layoutInflater.inflate(R.layout.fragment_account_details_flow, container, false)

    override fun navigation(screen: AccountDetailsRouter) {
        val navController =
            (childFragmentManager.findFragmentById(R.id.fragmentAccountDetailsContainer) as NavHostFragment)
                .navController
        when (screen) {
            AccountDetailsRouter.Main -> navController.setGraph(
                R.navigation.account_details_nav_graph
            )

            is AccountDetailsRouter.SimplePay -> /*navigate(
                NavCommands.Activity(Intent(requireActivity(), screen.activityDetails).putExtra(screen.extra, screen.id))
            )*/ TODO()
        }
    }
}