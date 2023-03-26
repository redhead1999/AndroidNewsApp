package com.aold.runewsapp.navigation

import com.aold.core.core.navigations.GlobalRouter
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.02.2023.
 */

interface AppNavigationManager {

    fun showNavFragment()

    fun selectNewsFeature()

    fun selectSettingsFeature()


    //TODO пофиксить после добавления новых модулей
    class Base @Inject constructor(
//        private val newsFeatureStarter: Provider<NewsFeatureStarter>,
//        private val settingsFeatureStarter: Provider<NewsSettingsFeatureStarter>,
        private val globalRouter: GlobalRouter
    ) : AppNavigationManager {

        override fun showNavFragment() {
            globalRouter.newRootScreen(GlobalRoutingScreen.fetchNavScreen())
        }

        override fun selectNewsFeature() {
            //todo
        }

        override fun selectSettingsFeature() {
            //todo
        }
    }
}