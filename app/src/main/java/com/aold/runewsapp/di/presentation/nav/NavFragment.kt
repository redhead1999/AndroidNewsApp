package com.aold.runewsapp.di.presentation.nav

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.aold.core.navigations.CustomAppNavigator
import com.aold.core.platform.fragments.BaseFragmentWithViewModel
import com.aold.runewsapp.R
import com.aold.runewsapp.application.getApp
import com.aold.runewsapp.databinding.BottomNavFragmentBinding
import com.aold.runewsapp.di.annotation.NavCiceroneHolder
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */
class NavFragment : BaseFragmentWithViewModel<BottomNavFragmentBinding, NavViewModel>(
    BottomNavFragmentBinding::inflate
) {

}