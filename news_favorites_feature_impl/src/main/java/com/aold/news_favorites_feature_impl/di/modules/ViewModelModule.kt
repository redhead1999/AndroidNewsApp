package com.aold.news_favorites_feature_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import com.aold.news_favorites_feature_impl.presentation.ui.FavoritesViewModel

/**
 * @author Kirilin Yury on 27.03.2023.
 */

@Module
internal interface ViewModelModule {

    @Binds
    fun provideFavoritesViewModel(viewModel: FavoritesViewModel): ViewModel

    @Binds
    fun provideFavoritesViewModelFactory(factory: FavoritesViewModel.Factory): ViewModelProvider.Factory
}