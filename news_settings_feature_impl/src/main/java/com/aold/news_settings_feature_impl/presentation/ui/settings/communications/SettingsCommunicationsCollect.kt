package com.aold.news_settings_feature_impl.presentation.ui.settings.communications

import androidx.lifecycle.LifecycleOwner
import com.aold.news_settings_feature_impl.presentation.models.SettingsUi
import com.aold.news_settings_feature_impl.presentation.ui.settings.common.SettingsState
import kotlinx.coroutines.flow.FlowCollector

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal interface SettingsCommunicationsCollect {
    fun collectState(lifecycle: LifecycleOwner, collector: FlowCollector<SettingsState>)
    fun collectSettings(lifecycle: LifecycleOwner, collector: FlowCollector<SettingsUi>)
}