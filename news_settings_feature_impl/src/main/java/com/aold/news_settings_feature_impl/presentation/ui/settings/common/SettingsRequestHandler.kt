package com.aold.news_settings_feature_impl.presentation.ui.settings.common

import com.aold.core.core.functional.Either
import com.aold.core.core.managers.CoroutineManager
import com.aold.news_settings_feature_api.domain.SettingsEntity
import com.aold.news_settings_feature_impl.domain.common.SettingsFailures
import com.aold.news_settings_feature_impl.presentation.mappers.SettingsDomainToUiMapper
import com.aold.news_settings_feature_impl.presentation.ui.settings.communications.SettingsCommunications
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.03.2023.
 */

internal interface SettingsRequestHandler {

    fun handleEitherSettings(
        scope: CoroutineScope,
        block: suspend () -> Either<SettingsFailures, SettingsEntity>
    )

    class Base @Inject constructor(
        private val coroutineManager: CoroutineManager,
        private val communications: SettingsCommunications,
        private val mapperToUi: SettingsDomainToUiMapper
    ) : SettingsRequestHandler {

        override fun handleEitherSettings(
            scope: CoroutineScope,
            block: suspend () -> Either<SettingsFailures, SettingsEntity>
        ) = coroutineManager.runOnBackground(scope) {
            when (val either = block.invoke()) {
                is Either.Right -> {
                    communications.showSettings(either.data.map(mapperToUi))
                    communications.showState(SettingsState.Settings())
                }
                is Either.Left -> {
                    communications.showState(SettingsState.Error())
                }
            }
        }
    }
}