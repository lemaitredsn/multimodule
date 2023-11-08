package ru.lemaite.common.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import ru.lemaitre.common.utils.allParents

interface NavigationProvider {
    fun launch(navCommand: NavCommand)
}

data class NavCommand(
    val target: NavCommands,
    var args: Bundle? = null,
    val navOptions: NavOptions? = null
)

sealed class NavCommands {
    data class Browser(val url: String) : NavCommands()
    data class DeepLink(
        val url: Uri,
        val isModal: Boolean,
        val isSingleTop: Boolean = false
    ) : NavCommands()

    data class Activity(val intent: Intent): NavCommands()

    data class StartFragment(
        @NavigationRes
        val idFlow: Int
    ) : NavCommands()
}

fun Fragment.navigate(navCommand: NavCommand) {
    getNavigator.launch(navCommand)
}

val Fragment.getNavigator: NavigationProvider
    get() = allParents
        .mapNotNull { it as? NavigationProvider }
        .firstOrNull()
        ?: throw IllegalStateException("No navigation provider")
