package com.aold.news_feature_impl.domain.interactors

import androidx.paging.PagingData
import com.aold.core.core.functional.Either
import com.aold.news_feature_impl.domain.common.NewsEitherWrapper
import com.aold.news_feature_impl.domain.common.SettingsEitherToEntityMapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.domain.entities.NewsFailures
import com.aold.news_feature_impl.domain.repositories.NewsRepository
import com.aold.news_feature_impl.domain.repositories.SettingsRepository
import com.aold.news_settings_feature_api.domain.Categories
import com.aold.news_settings_feature_api.domain.SettingsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal interface NewsInteractor {

    suspend fun fetchPagingNews(category: Categories?): Flow<PagingData<NewsEntity>>

    suspend fun fetchSettings(): Either<NewsFailures, SettingsEntity>

    class Base @Inject constructor(
        private val newsRepository: NewsRepository,
        private val settingsRepository: SettingsRepository,
        private val eitherWrapper: NewsEitherWrapper,
        private val settingsMapper: SettingsEitherToEntityMapper
    ) : NewsInteractor {

        override suspend fun fetchPagingNews(category: Categories?): Flow<PagingData<NewsEntity>> {
            val correctSettings = settingsMapper.map(fetchSettings(), category)
            return newsRepository.fetchNews(
                correctSettings.defaultCategory.data,
                correctSettings.language.data,
                correctSettings.country.data
            )
        }

        override suspend fun fetchSettings() = eitherWrapper.wrap {
            settingsRepository.fetchSettings()
        }
    }
}
