package ru.lemaitre.mymultymodule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment: Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = (childFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment)
            .navController
        bottomNavigationView.setupWithNavController(navController)
    }
}