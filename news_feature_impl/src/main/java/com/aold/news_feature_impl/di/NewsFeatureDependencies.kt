package com.aold.news_feature_impl.di

import android.content.Context
import com.aold.core.core.navigations.BottomNavRouter
import com.aold.core_db.details.NewsDetailsLocalDataSource
import com.aold.core_db.settings.SettingsLocalDataSource
import com.aold.module_injector.BaseFeatureDependencies

/**
 * @author {Kirilin Yury} on 28.02.2023.
 */

interface NewsFeatureDependencies : BaseFeatureDependencies {
    val applicationContext: Context
    val navRouter: BottomNavRouter
    //val detailsFeatureStarter: NewsDetailsFeatureStarter
    val settingsLocalDataSource: SettingsLocalDataSource
    val detailsLocalDataSource: NewsDetailsLocalDataSource
}