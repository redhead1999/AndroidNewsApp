package com.aold.runewsapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import com.aold.runewsapp.di.annotation.MainViewModels
import com.aold.runewsapp.di.annotation.NavViewModels
import com.aold.runewsapp.presentation.activity.MainViewModel
import com.aold.runewsapp.presentation.nav.NavViewModel

/**
 * @author Kirilin Yury on 26.02.2023.
 */

@Module
interface ViewModelModule {

    @Binds
    @MainViewModels
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @MainViewModels
    fun provideMainViewModelFactory(factory: MainViewModel.Factory): ViewModelProvider.Factory

    @Binds
    @NavViewModels
    fun provideNavViewModel(viewModel: NavViewModel): ViewModel

    @Binds
    @NavViewModels
    fun provideNavViewModelFactory(factory: NavViewModel.Factory): ViewModelProvider.Factory
}