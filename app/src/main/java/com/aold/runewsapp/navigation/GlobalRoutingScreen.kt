package com.aold.runewsapp.navigation

import com.aold.runewsapp.presentation.nav.NavFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen


/**
 * @author Stanislav Aleshin on 28.10.2022.
 */
object GlobalRoutingScreen {

    fun fetchNavScreen() = FragmentScreen(NavigationKeys.NAV_FRAGMENT) {
       NavFragment()
    }
}

object NavigationKeys {
    const val NAV_FRAGMENT = "NavFragment"
}