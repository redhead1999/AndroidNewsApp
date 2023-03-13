package com.aold.news_feature_impl.data.repositories

import com.aold.core_db.details.NewsDetailsLocalDataSource
import com.aold.news_feature_impl.data.mappers.NewsDetailsDomainToMapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.domain.repositories.DetailsRepository
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */
internal class DetailsRepositoryImpl @Inject constructor(
    private val localDataSource: NewsDetailsLocalDataSource,
    private val mapperToData: NewsDetailsDomainToMapper
) : DetailsRepository {
    override suspend fun setNews(news: NewsEntity) {
        localDataSource.save(news.map(mapperToData))
    }
}