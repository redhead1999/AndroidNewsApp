package com.aold.news_feature_impl.data.repositories

import androidx.paging.PagingData
import androidx.paging.map
import com.aold.news_feature_impl.data.data_sources.network.NewsPagingDataSource
import com.aold.news_feature_impl.data.data_sources.network.service.NewsRequest
import com.aold.news_feature_impl.data.mappers.NewsDataToDomainMapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.domain.repositories.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

internal class NewsRepositoryImpl @Inject constructor(
    private val pagingDataSource: NewsPagingDataSource,
    private val mapperToDomain: NewsDataToDomainMapper
) : NewsRepository {

    override fun fetchNews(
        category: String,
        language: String,
        country: String
    ): Flow<PagingData<NewsEntity>> {
        val newsRequest = NewsRequest(category, language, country)

        return pagingDataSource.fetchNews(newsRequest).map { pagingData ->
            pagingData.map { mapperToDomain.map(it) }
        }
    }


}