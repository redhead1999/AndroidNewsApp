package com.aold.news_settings_feature_impl.presentation.mappers

import com.aold.core.core.common.Mapper
import com.aold.news_settings_feature_api.domain.SettingsEntity
import com.aold.news_settings_feature_impl.presentation.models.SettingsUi
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal interface SettingsDomainToUiMapper : Mapper<SettingsEntity, SettingsUi> {

    class Base @Inject constructor() : SettingsDomainToUiMapper {
        override fun map(input: SettingsEntity) = SettingsUi(
            language = input.language,
            country = input.country,
            category = input.defaultCategory)
    }
}

internal interface SettingsUiToDomainMapper : Mapper<SettingsUi, SettingsEntity> {

    class Base @Inject constructor() : SettingsUiToDomainMapper {
        override fun map(input: SettingsUi) = SettingsEntity(
            language = input.language,
            country = input.country,
            defaultCategory = input.category
        )
    }
}