package lemaite.simplepay.flow

import android.os.Bundle
import lemaite.simplepay.R
import moxy.MvpAppCompatActivity

class SimplePayFlowActivity: MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_pay_flow)
    }

    companion object {
        const val EXTRA_ID = "SimplePayFlowActivity.EXTRA_ID"
    }
}

