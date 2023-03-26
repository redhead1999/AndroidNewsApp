package com.aold.news_settings_feature_api.data

import com.aold.core.core.common.Mapper
import com.aold.core_db.settings.SettingsModel
import com.aold.news_settings_feature_api.domain.SettingsEntity
import com.aold.news_settings_feature_api.domain.convertToCategory
import com.aold.news_settings_feature_api.domain.convertToCountry
import com.aold.news_settings_feature_api.domain.convertToLanguage

/**
 * @author Kirilin Yury on 03.03.2023.
 */

interface SettingsDataToDomainMapper : Mapper<SettingsModel, SettingsEntity> {

    class Base : SettingsDataToDomainMapper {
        override fun map(input: SettingsModel) = SettingsEntity(
            language = input.language.convertToLanguage(),
            country = input.country.convertToCountry(),
            defaultCategory = input.defualtCategory.convertToCategory()
        )
    }
}

interface SettingsDomainToDataMapper : Mapper<SettingsEntity, SettingsModel> {

    class Base : SettingsDomainToDataMapper {
        override fun map(input: SettingsEntity) = SettingsModel(
            id = SettingsEntity.DEFAULT_ID,
            language = input.language.data,
            country = input.country.data,
            defualtCategory = input.defaultCategory.data
        )
    }
}