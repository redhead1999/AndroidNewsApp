package com.aold.news_feature_impl.domain.common

import com.aold.core.core.functional.Either
import com.aold.news_feature_impl.domain.entities.NewsFailures
import com.aold.news_settings_feature_api.domain.Categories
import com.aold.news_settings_feature_api.domain.SettingsEntity
import javax.inject.Inject

/**
 * @author Kirilin Yury on 14.03.2023.
 */

internal interface SettingsEitherToEntityMapper {

    fun map(either: Either<NewsFailures, SettingsEntity>, category: Categories?): SettingsEntity

    class Base @Inject constructor() : SettingsEitherToEntityMapper {

        override fun map(
            either: Either<NewsFailures, SettingsEntity>,
            category: Categories?
        ): SettingsEntity = when (either) {
            is Either.Right -> SettingsEntity(
                language = either.data.language,
                country = either.data.country,
                defaultCategory = category ?: either.data.defaultCategory
            )
            is Either.Left -> SettingsEntity(
                language = SettingsEntity.DEFAULT_LANGUAGES,
                country = SettingsEntity.DEFUALT_COUNTRY,
                defaultCategory = category ?: SettingsEntity.DEFUALT_CATEGORY
            )
        }
    }
}