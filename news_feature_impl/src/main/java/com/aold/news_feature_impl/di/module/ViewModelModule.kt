package com.aold.news_feature_impl.di.module

import com.aold.core.core.di.FeatureScope
import com.aold.core.core.platform.viewmodel.BaseViewModel
import com.aold.news_feature_impl.navigation.NavigationManager
import com.aold.news_feature_impl.presentation.ui.news.NewsViewModel
import com.aold.news_feature_impl.presentation.ui.news.common.NewsRequestHandler
import com.aold.news_feature_impl.presentation.ui.news.communications.NewsCommunications
import com.aold.news_feature_impl.presentation.ui.news.communications.NewsStateCommunicator
import com.aold.news_feature_impl.presentation.ui.news.communications.PagingNewsCommunicator
import dagger.Binds
import dagger.Module


/**
 * @author Kirilin Yury on 27.03.2023.
 */

@Module
internal interface ViewModelModule {

    @Binds
    fun provideNavigationManager(manager: NavigationManager.Base): NavigationManager

    @Binds
    fun provideNewsViewModel(viewModel: NewsViewModel): BaseViewModel

    @Binds
    fun provideNewsViewModelFactory(factory: NewsViewModel.Factory): BaseViewModel.BaseViewModelFactory

    @Binds
    @FeatureScope
    fun provideNewsCommunications(communications: NewsCommunications.Base): NewsCommunications

    @Binds
    fun provideNewsStateCommunicator(communicator: NewsStateCommunicator.Base): NewsStateCommunicator

    @Binds
    fun providePagingNewsCommunicator(communicator: PagingNewsCommunicator.Base): PagingNewsCommunicator

    @Binds
    fun provideNewsRequestHandler(handler: NewsRequestHandler.Base): NewsRequestHandler
}