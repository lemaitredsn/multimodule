package com.chat.feature.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.chat.feature.R
import com.chat.feature.di.ChatComponent
import com.chat.feature.di.DaggerChatComponent
import com.example.api.ChatDeps
import moxy.MvpAppCompatFragment
import ru.lemaitre.common.utils.ComponentProvider
import ru.lemaitre.common.utils.findDependencies
import ru.lemaitre.common.utils.scopedComponent

internal class ChatFlowFragment() : MvpAppCompatFragment(), ChatFlowView,
    ComponentProvider<ChatComponent> {

    override val component: ChatComponent by scopedComponent {
        DaggerChatComponent
            .factory()
            .create(findDependencies<ChatDeps>())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = layoutInflater.inflate(R.layout.fragment_chat_flow, container, false)


    override fun navigate(screen: ChatRoute) {
        val navController =
            (childFragmentManager.findFragmentById(R.id.chat_container) as NavHostFragment)
                .navController

        when(screen){
            ChatRoute.Main -> navController.setGraph(R.navigation.chat_flow_nav_graph)
        }
    }
}