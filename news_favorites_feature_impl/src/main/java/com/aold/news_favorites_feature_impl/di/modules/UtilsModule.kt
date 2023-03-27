package com.aold.news_favorites_feature_impl.di.modules

import com.aold.core.core.managers.CoroutineManager
import com.aold.news_favorites_feature_api.NewsFavoritesFeatureStarter
import dagger.Binds
import dagger.Module
import com.aold.news_favorites_feature_impl.navigation.NewsFavoritesFeatureStarterImpl

/**
 * @author Kirilin Yury on 27.03.2023.
 */

@Module
internal interface UtilsModule {

    @Binds
    fun provideFeatureStarter(starter: NewsFavoritesFeatureStarterImpl): NewsFavoritesFeatureStarter

    @Binds
    fun provideCoroutineManager(manager: CoroutineManager.Base): CoroutineManager
}