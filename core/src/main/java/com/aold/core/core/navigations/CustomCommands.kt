package com.aold.core.core.navigations

import android.content.Intent
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

data class ShowDialog(val screen: DialogScreen) : Command

data class CloseDialog(val screen: DialogScreen) : Command

data class ShowBottomSheetScreen(val screen: BottomSheetFragmentScreen) : Command

data class ChangeTabFragment(val screen: FragmentScreen) : Command

data class ShowIntent(val intent: Intent) : Command