package com.aold.news_feature_impl.data.repositories

import com.aold.core_db.settings.SettingsLocalDataSource
import com.aold.news_feature_impl.domain.repositories.SettingsRepository
import com.aold.news_settings_feature_api.data.SettingsDataToDomainMapper
import com.aold.news_settings_feature_api.domain.SettingsEntity
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal class SettingsRepositoryImpl @Inject constructor(
    private val localDataSource: SettingsLocalDataSource,
    private val mapper: SettingsDataToDomainMapper
) : SettingsRepository {

    override suspend fun fetchSettings(): SettingsEntity {
        return localDataSource.fetchSettings().map(mapper)
    }
}