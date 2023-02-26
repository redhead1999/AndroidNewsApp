package com.aold.runewsapp.navigation

import javax.inject.Inject
import javax.inject.Provider

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

interface AppNavigationManager {

    fun showNavFragment()

    fun selectNewsFeature()

    fun selectSettingsFeature()

    class Base @Inject constructor(
        private val newsFeatureStarter: Provider<NewsFeatureStarter>,
        private val settingsFeatureStarter: Provider<NewsSettingsFeatureStarter>,
        private val globalRouter: GlobalRouter
    ) : AppNavigationManager {

        override fun showNavFragment() {
            globalRouter.newRootScreen(GlobalRoutingScreen.fetchNavScreen())
        }

        override fun selectNewsFeature() {
            newsFeatureStarter.get().showFeature()
        }

        override fun selectSettingsFeature() {
            settingsFeatureStarter.get().showFeature()
        }
    }
}