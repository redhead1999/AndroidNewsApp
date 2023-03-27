package com.aold.news_feature_impl.di.module

import android.content.Context
import com.aold.core.core.managers.CoroutineManager
import com.aold.core.core.managers.DateManager
import com.aold.core.core.managers.ResourceManager
import com.aold.core.core.navigations.BottomNavRouter
import com.aold.news_feature_api.NewsFeatureStarter
import com.aold.news_feature_impl.navigation.NewsFeatureStarterImpl
import com.aold.news_settings_feature_api.data.SettingsDataToDomainMapper
import com.aold.news_settings_feature_api.data.SettingsDomainToDataMapper
import dagger.Module
import dagger.Provides

/**
 * @author Kirilin Yury on 27.03.2023.
 */

@Module
internal class UtilsModule {

    @Provides
    fun provideNewsFeatureStarter(navRouter: BottomNavRouter): NewsFeatureStarter {
        return NewsFeatureStarterImpl(navRouter)
    }

    @Provides
    fun provideCoroutineManager(): CoroutineManager {
        return CoroutineManager.Base()
    }

    @Provides
    fun provideSettingsDomainToDataMapper(): SettingsDomainToDataMapper {
        return SettingsDomainToDataMapper.Base()
    }

    @Provides
    fun provideSettingsDataToDomainMapper(): SettingsDataToDomainMapper {
        return SettingsDataToDomainMapper.Base()
    }

    @Provides
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManager.Base(context)
    }

    @Provides
    fun provideDateManager(): DateManager {
        return DateManager.Base()
    }
}