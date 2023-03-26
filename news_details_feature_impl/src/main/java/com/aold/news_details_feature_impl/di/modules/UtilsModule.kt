package com.aold.news_details_feature_impl.di.modules

import com.aold.core.core.managers.CoroutineManager
import com.aold.news_details_feature_api.NewsDetailsFeatureStarter
import com.aold.news_details_feature_impl.navigations.NavigationManager
import com.aold.news_details_feature_impl.navigations.NewsDetailsFeatureStarterImpl
import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 18.03.2023.
 */

@Module
internal interface UtilsModule {

    @Binds
    fun provideDetailsFeatureStarter(starter: NewsDetailsFeatureStarterImpl): NewsDetailsFeatureStarter

    @Binds
    fun provideCoroutineManager(manager: CoroutineManager.Base): CoroutineManager

    @Binds
    fun provideNavigationManager(manager: NavigationManager.Base): NavigationManager
}