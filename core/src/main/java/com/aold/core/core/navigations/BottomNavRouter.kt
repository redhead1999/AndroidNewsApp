package com.aold.core.core.navigations

import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * @author Kirilin Yury on 26.02.2023.
 */

class BottomNavRouter : GlobalRouter() {
    fun selectBottomTabScreen(screen: FragmentScreen) {
        executeCommands(ChangeTabFragment(screen))
    }
}