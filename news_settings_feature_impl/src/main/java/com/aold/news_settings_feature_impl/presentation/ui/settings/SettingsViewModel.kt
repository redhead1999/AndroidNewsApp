package com.aold.news_settings_feature_impl.presentation.ui.settings

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.aold.core.core.managers.CoroutineManager
import com.aold.core.core.platform.viewmodel.BaseViewModel
import com.aold.core.core.platform.viewmodel.Init
import com.aold.news_settings_feature_api.domain.Categories
import com.aold.news_settings_feature_api.domain.Countries
import com.aold.news_settings_feature_api.domain.Languages
import com.aold.news_settings_feature_impl.domain.interactor.SettingsInteractor
import com.aold.news_settings_feature_impl.navigation.SettingsNavigationManager
import com.aold.news_settings_feature_impl.presentation.models.SettingsUi
import com.aold.news_settings_feature_impl.presentation.ui.settings.common.SettingsRequestHandler
import com.aold.news_settings_feature_impl.presentation.ui.settings.common.SettingsState
import com.aold.news_settings_feature_impl.presentation.ui.settings.communications.SettingsCommunications
import com.aold.news_settings_feature_impl.presentation.ui.settings.communications.SettingsCommunicationsCollect
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal class SettingsViewModel @Inject constructor(
    private val interactor: SettingsInteractor,
    private val requestHandler: SettingsRequestHandler,
    private val communications: SettingsCommunications,
    private val navigationManager: SettingsNavigationManager,
    coroutineManager: CoroutineManager
) : BaseViewModel(coroutineManager), SettingsCommunicationsCollect, Init {

    override fun init(itFirstStart: Boolean) {
        if (itFirstStart) {
            requestHandler.handleEitherSettings(viewModelScope) { interactor.fetchSettings() }
        }
    }

    fun updateSettings(
        categories: Categories? = null,
        countries: Countries? = null,
        languages: Languages? = null
    ) = requestHandler.handleEitherSettings(viewModelScope) {
        interactor.updateSettings(categories, countries, languages)
    }

    fun pressCategorySettingsItem() {
        navigationManager.showCategoriesDialog()
    }

    fun pressLanguageSettingsItem() {
        navigationManager.showLanguagesDialog()
    }

    fun pressCountrySettingsItem() {
        navigationManager.showCountriesDialog()
    }

    override fun collectState(lifecycle: LifecycleOwner, collector: FlowCollector<SettingsState>) =
        communications.collectState(lifecycle, collector)

    override fun collectSettings(lifecycle: LifecycleOwner, collector: FlowCollector<SettingsUi>) =
        communications.collectSettings(lifecycle, collector)

    class Factory @Inject constructor(viewModel: Provider<SettingsViewModel>) :
        BaseViewModelFactory(viewModel)
}