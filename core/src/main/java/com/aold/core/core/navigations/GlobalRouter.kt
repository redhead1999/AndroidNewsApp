package com.aold.core.core.navigations

import android.content.Intent
import com.github.terrakok.cicerone.Router

/**
 * @author Kirilin Yury on 26.02.2023.
 */
open class GlobalRouter : Router() {

    fun showDialog(screen: DialogScreen) {
        executeCommands(ShowDialog(screen))
    }

    fun closeDialog(screen: DialogScreen) {
        executeCommands(CloseDialog(screen))
    }

    fun showBottomSheetFragment(screen: BottomSheetFragmentScreen) {
        executeCommands(ShowBottomSheetScreen(screen))
    }

    fun showIntent(intent: Intent) {
        executeCommands(ShowIntent(intent))
    }
}