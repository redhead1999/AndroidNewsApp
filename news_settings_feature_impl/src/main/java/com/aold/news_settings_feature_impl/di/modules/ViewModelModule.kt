package com.aold.news_settings_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.core.core.platform.viewmodel.BaseViewModel
import com.aold.news_settings_feature_impl.presentation.ui.settings.SettingsViewModel
import com.aold.news_settings_feature_impl.presentation.ui.settings.common.SettingsRequestHandler
import com.aold.news_settings_feature_impl.presentation.ui.settings.communications.SettingsCommunications
import com.aold.news_settings_feature_impl.presentation.ui.settings.communications.SettingsCommunicator
import com.aold.news_settings_feature_impl.presentation.ui.settings.communications.SettingsStateCommunicator
import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 03.03.2023.
 */
@Module
internal interface ViewModelModule {

    @Binds
    fun provideSettingsViewModel(viewModel: SettingsViewModel): BaseViewModel

    @Binds
    fun provideSettingsViewModelFactory(factory: SettingsViewModel.Factory): BaseViewModel.BaseViewModelFactory

    @Binds
    fun provideSettingsRequestHandler(handler: SettingsRequestHandler.Base): SettingsRequestHandler

    @Binds
    fun provideSettingsStateCommunicator(communicator: SettingsStateCommunicator.Base): SettingsStateCommunicator

    @Binds
    fun provideSettingsCommunicator(communicator: SettingsCommunicator.Base): SettingsCommunicator

    @Binds
    @FeatureScope
    fun provideSettingsCommunications(communicator: SettingsCommunications.Base): SettingsCommunications
}