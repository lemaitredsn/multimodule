package ru.lemaitre.mymultymodule

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.lemaite.common.navigation.NavCommand
import ru.lemaite.common.navigation.NavCommands
import ru.lemaite.common.navigation.NavigationProvider

class MainFragment : Fragment(R.layout.fragment_main), NavigationProvider {

    private val navController
        get() = (childFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment)
            .navController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView =
            view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
//            bottomNavigationView.isVisible = destination.id != R.id.chatFlowFragment
        }
    }

    override fun launch(navCommand: NavCommand) {
        when (val target = navCommand.target) {
            is NavCommands.Activity -> requireActivity().startActivity(target.intent)
            is NavCommands.DeepLink -> openDeepLink(
                url = target.url,
                isModal = target.isModal,
                isSingleTop = target.isSingleTop
            )
            is NavCommands.Browser -> error("no implement test")

            is NavCommands.StartFragment -> navController.setGraph(target.idFlow)
        //возможно это не так должно работать, возможно должен быть общий граф приложения в котором будет хранится все флоу и переходить по ним,
            //так же возможно и сделать навигацию
            /*
            is NavCommands.StartFragment -> navController.navigate(target.idFlow)
            is NavCommands.Back -> navCommand.backto previos flow //выход из флоу
            is NavCommands.Exit -> navCommand.backto previos flow
             */
        }
    }

    private fun openDeepLink(url: Uri, isModal: Boolean, isSingleTop: Boolean) {
        val navOptions = if (isModal) {
            NavOptions.Builder()
                .setLaunchSingleTop(isSingleTop)
                .setPopUpTo(if (isSingleTop) R.id.app_graph_xml else -1, inclusive = isSingleTop)
                .build()
        } else {
            NavOptions.Builder()
                .setLaunchSingleTop(isSingleTop)
                .setPopUpTo(if (isSingleTop) R.id.app_graph_xml else -1, inclusive = isSingleTop)
                .build()
        }
        //fixme тест
        navController
            .navigate(R.id.chatFlowFragment, null, navOptions)
    }
}