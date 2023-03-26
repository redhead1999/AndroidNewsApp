package com.aold.news_feature_impl.domain.repositories

import com.aold.news_settings_feature_api.domain.SettingsEntity

/**
 * @author Kirilin Yury on 28.02.2023.
 */
internal interface SettingsRepository {
    suspend fun fetchSettings(): SettingsEntity
}