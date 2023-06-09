package ru.lemaitre.account_details.flow

import android.os.Bundle
import android.widget.TextView
import moxy.MvpAppCompatActivity
import ru.lemaitre.account_details.R

class AccountDetailsFlowActivity: MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_details)
    }

    companion object {
        const val EXTRA_ID = "AccountDetailsActivity.ID"
    }
}