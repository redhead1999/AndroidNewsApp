package com.aold.news_settings_feature_impl.data.repository

import com.aold.core_db.settings.SettingsLocalDataSource
import com.aold.news_settings_feature_api.data.SettingsDataToDomainMapper
import com.aold.news_settings_feature_api.data.SettingsDomainToDataMapper
import com.aold.news_settings_feature_api.domain.SettingsEntity
import com.aold.news_settings_feature_impl.domain.repository.SettingsRepository
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */
internal class SettingsRepositoryImpl @Inject constructor(
    private val localDataSource: SettingsLocalDataSource,
    private val mapperToDomain: SettingsDataToDomainMapper,
    private val mapperToData: SettingsDomainToDataMapper
) : SettingsRepository {
    override suspend fun fetchSettings(): SettingsEntity {
        return localDataSource.fetchSettings().map(mapperToDomain)
    }

    override suspend fun updateSettings(settings: SettingsEntity) {
        return localDataSource.updateSettings(settings.map(mapperToData))
    }


}