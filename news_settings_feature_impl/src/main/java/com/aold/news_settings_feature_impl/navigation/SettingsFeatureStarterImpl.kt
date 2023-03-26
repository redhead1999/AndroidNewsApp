package com.aold.news_settings_feature_impl.navigation

import com.aold.core.core.navigations.BottomNavRouter
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureStarter
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal class SettingsFeatureStarterImpl @Inject constructor(
    private val navRouter: BottomNavRouter
) : NewsSettingsFeatureStarter {

    override fun showFeature() {
        navRouter.selectBottomTabScreen(SettingsRoutingScreens.fetchSettingsScreen())
    }
}