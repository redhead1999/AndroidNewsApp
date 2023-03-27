package com.aold.news_settings_feature_impl.navigation

import com.aold.core.core.navigations.BottomNavRouter
import javax.inject.Inject

/**
 * @author Kirilin Yury on 27.03.2023.
 */

internal interface SettingsNavigationManager {

    fun showCategoriesDialog()

    fun showLanguagesDialog()

    fun showCountriesDialog()

    class Base @Inject constructor(
        private val router: BottomNavRouter
    ) : SettingsNavigationManager {

        override fun showCategoriesDialog() {
            router.showDialog(SettingsRoutingScreens.fetchCategoriesDialogScreen())
        }

        override fun showLanguagesDialog() {
            router.showDialog(SettingsRoutingScreens.fetchLanguagesDialogScreen())
        }

        override fun showCountriesDialog() {
            router.showDialog(SettingsRoutingScreens.fetchCountriesDialogScreen())
        }
    }
}