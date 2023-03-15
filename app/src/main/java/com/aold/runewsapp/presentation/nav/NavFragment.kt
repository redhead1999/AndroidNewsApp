package com.aold.runewsapp.presentation.nav

import android.os.Bundle
import com.aold.core.core.navigations.CustomAppNavigator
import com.aold.core.core.platform.fragments.BaseFragmentWithViewModel
import com.aold.runewsapp.R
import com.aold.runewsapp.databinding.BottomNavFragmentBinding
import com.aold.runewsapp.di.annotation.NavCiceroneHolder
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

class NavFragment : BaseFragmentWithViewModel<BottomNavFragmentBinding, NavViewModel>(
    BottomNavFragmentBinding::inflate
) {

    @Inject
    lateinit var factory: NavViewModel.Factory

    @Inject
    @NavCiceroneHolder
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator by lazy(LazyThreadSafetyMode.NONE) {
        CustomAppNavigator(requireActivity(), R.id.fragmentContainer, childFragmentManager)
    }

    override fun initDI() = requireContext().getApp().fetchAppComponent().inject(this)

    override fun initView(savedInstanceState: Bundle?) = with(requireViewBinding()) {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.newsFragment -> { viewModel.pressNewsItem(); true }
                R.id.settingsFragment -> { viewModel.pressSettingsItem(); true }
                else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun fetchViewModelClass() = NavViewModel::class.java

    override fun fetchViewModelFactory() = factory
}