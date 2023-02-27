package com.aold.runewsapp.navigation

import com.aold.runewsapp.presentation.nav.NavFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen


/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

object GlobalRoutingScreen {

    fun fetchNavScreen() = FragmentScreen(NavigationKeys.NAV_FRAGMENT) {
       NavFragment()
    }
}

object NavigationKeys {
    const val NAV_FRAGMENT = "NavFragment"
}