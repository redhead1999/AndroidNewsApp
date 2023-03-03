package com.aold.news_settings_feature_impl.di.modules

import com.aold.core.core.managers.CoroutineManager
import com.aold.core.core.navigations.BottomNavRouter
import com.aold.news_settings_feature_api.data.SettingsDataToDomainMapper
import com.aold.news_settings_feature_api.data.SettingsDomainToDataMapper
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureStarter
import dagger.Module
import dagger.Provides

/**
 * @author Kirilin Yury on 03.03.2023.
 */

@Module
internal class UtilsModule {

    @Provides
    fun provideCoroutineManager(): CoroutineManager {
        return CoroutineManager.Base()
    }

    @Provides
    fun provideFeatureStarter(router: BottomNavRouter): NewsSettingsFeatureStarter {
        return SettingsFeatureStarterImpl(router)
    }

    @Provides
    fun provideNavigationManager(router: BottomNavRouter): SettingsNavigationManager {
        return SettingsNavigationManager.Base(router)
    }

    @Provides
    fun provideSettingsDomainToDataMapper(): SettingsDomainToDataMapper {
        return SettingsDomainToDataMapper.Base()
    }

    @Provides
    fun provideSettingsDataToDomainMapper(): SettingsDataToDomainMapper {
        return SettingsDataToDomainMapper.Base()
    }
}