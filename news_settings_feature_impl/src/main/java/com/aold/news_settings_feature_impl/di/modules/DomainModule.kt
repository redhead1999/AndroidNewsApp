package com.aold.news_settings_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.news_settings_feature_impl.domain.common.SettingsEitherWrapper
import com.aold.news_settings_feature_impl.domain.common.SettingsErrorHandler
import com.aold.news_settings_feature_impl.domain.interactor.SettingsInteractor
import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 03.03.2023.
 */

@Module
internal interface DomainModule {

    @Binds
    @FeatureScope
    fun provideSettingsInteractor(interactor: SettingsInteractor.Base): SettingsInteractor

    @Binds
    fun provideSettingsEitherWrapper(wrapper: SettingsEitherWrapper.Base): SettingsEitherWrapper

    @Binds
    fun provideSettingsErrorHandler(handler: SettingsErrorHandler.Base): SettingsErrorHandler
}