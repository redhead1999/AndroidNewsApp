package com.aold.news_settings_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.news_settings_feature_impl.domain.common.SettingsEitherWrapper
import com.aold.news_settings_feature_impl.domain.common.SettingsErrorHandler
import com.aold.news_settings_feature_impl.domain.interactor.SettingsInteractor
import com.aold.news_settings_feature_impl.presentation.mappers.SettingsDomainToUiMapper
import com.aold.news_settings_feature_impl.presentation.mappers.SettingsUiToDomainMapper
import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 03.03.2023.
 */
@Module

internal interface PresentationModule {

    @Binds
    fun provideSettingsUiToDomainMapper(mapper: SettingsUiToDomainMapper.Base): SettingsUiToDomainMapper

    @Binds
    fun provideSettingsDomainToUiMapper(mapper: SettingsDomainToUiMapper.Base): SettingsDomainToUiMapper
}