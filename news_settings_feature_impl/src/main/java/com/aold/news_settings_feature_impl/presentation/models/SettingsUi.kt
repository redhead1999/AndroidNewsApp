package com.aold.news_settings_feature_impl.presentation.models

import com.aold.core.core.common.Mapper
import com.aold.news_settings_feature_api.domain.Categories
import com.aold.news_settings_feature_api.domain.Countries
import com.aold.news_settings_feature_api.domain.Languages
import com.aold.news_settings_feature_api.domain.SettingsEntity


/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal data class SettingsUi(
    val language: Languages = SettingsEntity.DEFAULT_LANGUAGES,
    val country: Countries = SettingsEntity.DEFUALT_COUNTRY,
    val category: Categories = SettingsEntity.DEFUALT_CATEGORY
) {
    fun <O> map(mapper: Mapper<SettingsUi, O>) = mapper.map(this)
}