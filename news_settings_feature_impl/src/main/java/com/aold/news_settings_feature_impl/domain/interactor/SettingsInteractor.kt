package com.aold.news_settings_feature_impl.domain.interactor

import com.aold.core.core.functional.Either
import com.aold.news_settings_feature_api.domain.Categories
import com.aold.news_settings_feature_api.domain.Countries
import com.aold.news_settings_feature_api.domain.Languages
import com.aold.news_settings_feature_api.domain.SettingsEntity
import com.aold.news_settings_feature_impl.domain.common.SettingsEitherWrapper
import com.aold.news_settings_feature_impl.domain.common.SettingsFailures
import com.aold.news_settings_feature_impl.domain.repository.SettingsRepository
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.03.2023.
 */

internal interface SettingsInteractor {

    suspend fun fetchSettings(): Either<SettingsFailures, SettingsEntity>

    suspend fun updateSettings(
        category: Categories?,
        country: Countries?,
        language: Languages?
    ): Either<SettingsFailures, SettingsEntity>

    class Base @Inject constructor(
        private val repository: SettingsRepository,
        private val eitherWrapper: SettingsEitherWrapper
    ) : SettingsInteractor {

        override suspend fun fetchSettings() = eitherWrapper.wrap {
            repository.fetchSettings()
        }

        override suspend fun updateSettings(
            category: Categories?,
            country: Countries?,
            language: Languages?
        ) = eitherWrapper.wrap {
            repository.fetchSettings().let { currentSettings ->
                val newsSettings = SettingsEntity(
                    language = language ?: currentSettings.language,
                    country = country ?: currentSettings.country,
                    defaultCategory = category ?: currentSettings.defaultCategory
                )
                repository.updateSettings(newsSettings)
                return@wrap newsSettings
            }
        }
    }
}