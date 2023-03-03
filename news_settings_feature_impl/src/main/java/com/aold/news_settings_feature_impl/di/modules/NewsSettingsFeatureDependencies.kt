package com.aold.news_settings_feature_impl.di.modules

import android.content.Context
import com.aold.core.core.navigations.BottomNavRouter
import com.aold.core_db.settings.SettingsLocalDataSource
import com.aold.module_injector.BaseFeatureDependencies

/**
 * @author Stanislav Aleshin on 24.10.2022.
 */
interface NewsSettingsFeatureDependencies : BaseFeatureDependencies {
    val applicationContext: Context
    val navRouter: BottomNavRouter
    val settingsLocalDataSource: SettingsLocalDataSource
}