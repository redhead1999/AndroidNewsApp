package com.aold.news_favorites_feature_impl.presentation.ui

import com.aold.core.core.managers.CoroutineManager
import com.aold.core.core.platform.viewmodel.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Kirilin Yury on 27.03.2023.
 */

internal class FavoritesViewModel @Inject constructor(
    coroutineManager: CoroutineManager
) : BaseViewModel(coroutineManager) {

    class Factory @Inject constructor(viewModel: Provider<FavoritesViewModel>) :
        BaseViewModelFactory(viewModel)
}