package com.aold.runewsapp.presentation.activity

import com.aold.core.managers.CoroutineManager
import com.aold.core.platform.viewmodel.BaseViewModel
import com.aold.core.platform.viewmodel.Init
import com.aold.runewsapp.navigation.AppNavigationManager
import javax.inject.Inject
import javax.inject.Provider


/**
 * @author Kirilin Yury on 26.02.2023.
 */

class MainViewModel @Inject constructor(
    private val navigationManager: AppNavigationManager,
    coroutineManager: CoroutineManager
) : BaseViewModel(coroutineManager), Init {

    override fun init(itFirstStart: Boolean) {
        if (itFirstStart) {
            navigationManager.showNavFragment()
            navigationManager.selectNewsFeature()
        }
    }

    class Factory @Inject constructor(viewModel: Provider<MainViewModel>) :
        BaseViewModelFactory(viewModel)
}