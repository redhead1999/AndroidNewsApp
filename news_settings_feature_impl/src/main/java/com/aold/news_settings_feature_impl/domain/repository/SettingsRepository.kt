package com.aold.news_settings_feature_impl.domain.repository

import com.aold.news_settings_feature_api.domain.SettingsEntity

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */

internal interface SettingsRepository {

    suspend fun fetchSettings(): SettingsEntity

    suspend fun updateSettings(settings: SettingsEntity)
}