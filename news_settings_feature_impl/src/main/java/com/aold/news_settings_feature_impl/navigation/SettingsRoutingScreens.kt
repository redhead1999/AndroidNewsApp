package com.aold.news_settings_feature_impl.navigation

import com.aold.core.core.navigations.DialogScreen
import com.aold.news_settings_feature_impl.presentation.ui.categories.CategoriesDialogFragment
import com.aold.news_settings_feature_impl.presentation.ui.countries.CountriesDialogFragment
import com.aold.news_settings_feature_impl.presentation.ui.languages.LanguagesDialogFragment
import com.aold.news_settings_feature_impl.presentation.ui.settings.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal object SettingsRoutingScreens {

    fun fetchSettingsScreen() = FragmentScreen(NavigationKeys.SETTINGS_FRAGMENT) {
        SettingsFragment()
    }

    fun fetchCategoriesDialogScreen() = DialogScreen(NavigationKeys.CATEGORIES_DIALOG_FRAGMENT) {
        CategoriesDialogFragment()
    }

    fun fetchLanguagesDialogScreen() = DialogScreen(NavigationKeys.LANGUAGES_DIALOG_FRAGMENT) {
        LanguagesDialogFragment()
    }

    fun fetchCountriesDialogScreen() = DialogScreen(NavigationKeys.COUNTRIES_DIALOG_FRAGMENT) {
        CountriesDialogFragment()
    }
}

internal object NavigationKeys {
    const val SETTINGS_FRAGMENT = "SETTINGS_FRAGMENT"

    const val CATEGORIES_DIALOG_FRAGMENT = "CATEGORIES_DIALOG_FRAGMENT"
    const val LANGUAGES_DIALOG_FRAGMENT = "LANGUAGES_DIALOG_FRAGMENT"
    const val COUNTRIES_DIALOG_FRAGMENT = "COUNTRIES_DIALOG_FRAGMENT"
}