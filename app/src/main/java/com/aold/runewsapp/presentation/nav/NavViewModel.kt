package com.aold.runewsapp.presentation.nav

import javax.inject.Inject
import javax.inject.Provider

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

class NavViewModel @Inject constructor(
    private val navigationManager: AppNavigationManager,
    coroutineManager: CoroutineManager
) : BaseViewModel(coroutineManager) {

    fun pressNewsItem() = navigationManager.selectNewsFeature()

    fun pressSettingsItem() = navigationManager.selectSettingsFeature()

    class Factory @Inject constructor(viewModel: Provider<NavViewModel>) :
        BaseViewModelFactory(viewModel)
}