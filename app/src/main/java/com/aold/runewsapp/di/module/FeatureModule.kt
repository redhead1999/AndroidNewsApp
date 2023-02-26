package com.aold.runewsapp.di.module

import dagger.Module
import dagger.Provides
import com.aold.news_details_feature_impl.di.NewsDetailsFeatureDependencies
import com.aold.news_details_feature_impl.di.holder.NewsDetailsComponentHolder
import com.aold.news_feature_impl.di.NewsFeatureDependencies
import com.aold.news_feature_impl.di.holder.NewsComponentHolder
import com.aold.news_settings_feature_impl.di.NewsSettingsFeatureDependencies
import com.aold.news_settings_feature_impl.di.holder.NewsSettingsComponentHolder

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

@Module
class FeatureModule {

    @Provides
    fun provideNewsFeatureStarter(
        dependencies: NewsFeatureDependencies
    ) = NewsComponentHolder.let {
        it.initComponent(dependencies)
        it.fetchApi().fetchFeatureStarter()
    }

    @Provides
    fun provideNewsSettingsFeatureStarter(
        dependencies: NewsSettingsFeatureDependencies
    ) = NewsSettingsComponentHolder.let {
        it.initComponent(dependencies)
        it.fetchApi().fetchFeatureStarter()
    }

    @Provides
    fun provideNewsDetailsFeatureStarter(
        dependencies: NewsDetailsFeatureDependencies
    ) = NewsDetailsComponentHolder.let {
        it.initComponent(dependencies)
        it.fetchApi().fetchFeatureStarter()
    }
}