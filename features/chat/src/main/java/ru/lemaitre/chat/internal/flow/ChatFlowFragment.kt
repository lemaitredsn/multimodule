package ru.lemaitre.chat.internal.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.lemaitre.chat.R
import ru.lemaitre.chat.internal.di.ChatComponent
import ru.lemaitre.chat.internal.di.DaggerChatComponent
import ru.lemaitre.core.ComponentProvider
import ru.lemaitre.core.scopedComponent

internal class ChatFlowFragment() : MvpAppCompatFragment(), ChatFlowView,
    ComponentProvider<ChatComponent> {

    override val component: ChatComponent by scopedComponent {
        DaggerChatComponent.create()
    }

    private val presenter by moxyPresenter {
        component.provideChatFlowPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_chat_flow, container, false)
    }

    override fun navigate(screen: ChatRoute) {
        val navController =
            (childFragmentManager.findFragmentById(R.id.chatContainer) as NavHostFragment)
                .navController
        when (screen) {
            ChatRoute.Chat -> navController.setGraph(R.navigation.chat_flow_nav_graph)
        }
    }
}