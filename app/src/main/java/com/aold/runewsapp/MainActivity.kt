package com.aold.runewsapp

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.aold.runewsapp.core.navigations.CustomAppNavigator
import com.aold.runewsapp.core.platform.activity.BaseActivity
import com.aold.runewsapp.databinding.ActivityMainBinding
import com.aold.runewsapp.di.annotation.GlobalCiceroneHolder
import com.aold.runewsapp.globalnews.R
import com.aold.runewsapp.globalnews.application.getApp
import com.aold.runewsapp.globalnews.databinding.ActivityMainBinding
import com.aold.runewsapp.globalnews.di.annotation.GlobalCiceroneHolder
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate
) {

    @Inject
    lateinit var factory: MainViewModel.Factory

    @Inject
    @GlobalCiceroneHolder
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator by lazy(LazyThreadSafetyMode.NONE){
        CustomAppNavigator(this, R.id.globalContainer)
    }

    override fun setTheme() = setTheme(com.aold.runewsapp.R.style.Theme_App_GlobalNews)

    override fun initDI() = getApp().fetchAppComponent().inject(this)

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.init(savedInstanceState == null)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun fetchViewModelClass() = MainViewModel::class.java

    override fun fetchViewModelFactory() = factory
}

}