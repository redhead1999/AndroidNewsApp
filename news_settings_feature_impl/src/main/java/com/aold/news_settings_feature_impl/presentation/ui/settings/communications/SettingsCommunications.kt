package com.aold.news_settings_feature_impl.presentation.ui.settings.communications

import androidx.lifecycle.LifecycleOwner
import com.aold.core.core.platform.communication.Communicator
import com.aold.news_settings_feature_impl.presentation.models.SettingsUi
import kotlinx.coroutines.flow.FlowCollector
import com.aold.news_settings_feature_impl.presentation.ui.settings.common.SettingsState
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal interface SettingsCommunications : SettingsCommunicationsCollect {

    suspend fun showState(state: SettingsState)

    suspend fun showSettings(settings: SettingsUi)

    suspend fun fetchState(): SettingsState

    suspend fun fetchSettings(): SettingsUi

    class Base @Inject constructor(
        private val settingsCommunicator: SettingsCommunicator,
        private val stateCommunicator: SettingsStateCommunicator
    ) : SettingsCommunications {

        override fun collectState(
            lifecycle: LifecycleOwner,
            collector: FlowCollector<SettingsState>
        ) = stateCommunicator.collect(lifecycle, collector)

        override fun collectSettings(
            lifecycle: LifecycleOwner,
            collector: FlowCollector<SettingsUi>
        ) = settingsCommunicator.collect(lifecycle, collector)

        override suspend fun showState(state: SettingsState) =
            stateCommunicator.update(state)

        override suspend fun showSettings(settings: SettingsUi) =
            settingsCommunicator.update(settings)

        override suspend fun fetchState() =
            stateCommunicator.read()

        override suspend fun fetchSettings() =
            settingsCommunicator.read()
    }
}

internal interface SettingsStateCommunicator : Communicator.Combined<SettingsState> {

    class Base @Inject constructor() : SettingsStateCommunicator,
        Communicator.AbstractStateFlow<SettingsState>(SettingsState.Settings())
}

internal interface SettingsCommunicator : Communicator.Combined<SettingsUi> {

    class Base @Inject constructor() : SettingsCommunicator,
        Communicator.AbstractSharedFlow<SettingsUi>()
}