package ru.lemaitre.common.utils

import androidx.recyclerview.widget.RecyclerView

inline fun <reified T : Any> RecyclerView.typedAdapter(): T {
    val adapter = this.adapter
    return if (adapter is T) {
        adapter
    } else {
        throw IllegalArgumentException("This is not [${T::class.java.simpleName} adapter]")
    }
}