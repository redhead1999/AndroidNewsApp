package com.aold.news_settings_feature_api.domain

import com.aold.core.core.common.Mapper

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */
data class SettingsEntity(
    val language: Languages,
    val country: Countries,
    val defaultCategory: Categories
) {
    fun <O> map(mapper: Mapper<SettingsEntity, O>) = mapper.map(this)

    companion object {
        const val DEFAULT_ID = 1
        val DEFAULT_LANGUAGES = Languages.RUSSIAN
        val DEFUALT_COUNTRY = Countries.RUSSIAN_FEDERATION
        val DEFUALT_CATEGORY = Categories.BREAKING_NEWS
    }
}