package com.aold.news_settings_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.news_settings_feature_impl.data.repository.SettingsRepositoryImpl
import com.aold.news_settings_feature_impl.domain.repository.SettingsRepository
import dagger.Binds
import dagger.Module

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */

@Module
internal interface DataModule {

    @Binds
    @FeatureScope
    fun provideSettingsRepository(repository: SettingsRepositoryImpl): SettingsRepository
}