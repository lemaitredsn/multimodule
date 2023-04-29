package ru.lemaitre.chat.internal.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import ru.lemaitre.chat.R

class ChatFragment : MvpAppCompatFragment(), ChatView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_chat, container, false)
    }
}