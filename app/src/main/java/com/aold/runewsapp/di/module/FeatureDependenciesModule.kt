package com.aold.runewsapp.di.module

import dagger.Binds
import dagger.Module
import com.aold.runewsapp.di.component.AppComponent
import com.aold.runewsapp.news_details_feature_impl.di.NewsDetailsFeatureDependencies
import com.aold.runewsapp.news_feature_impl.di.NewsFeatureDependencies
import com.aold.runewsapp.news_settings_feature_impl.di.NewsSettingsFeatureDependencies

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

@Module
interface FeatureDependenciesModule {

    @Binds
    fun provideNewsFeatureDependencies(component: AppComponent): NewsFeatureDependencies

    @Binds
    fun provideNewsDetailsFeatureDependencies(component: AppComponent): NewsDetailsFeatureDependencies

    @Binds
    fun provideNewsSettingsFeatureDependencies(component: AppComponent): NewsSettingsFeatureDependencies
}