package com.example.select_account.mvp

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.select_account.R
import moxy.MvpAppCompatFragment

internal class SelectAccountFragment: MvpAppCompatFragment(R.layout.fragment_select_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.back).setOnClickListener {

        }
    }
}