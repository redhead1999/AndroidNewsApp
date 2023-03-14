package com.aold.news_settings_feature_impl.di.modules

import android.content.Context
import com.aold.core.core.navigations.BottomNavRouter
import com.aold.core_db.settings.SettingsLocalDataSource
import com.aold.module_injector.BaseFeatureDependencies

/**
 * @author Kirilin Yury on 10.03.2023.
 */

interface NewsSettingsFeatureDependencies : BaseFeatureDependencies {
    val applicationContext: Context
    val navRouter: BottomNavRouter
    val settingsLocalDataSource: SettingsLocalDataSource
}