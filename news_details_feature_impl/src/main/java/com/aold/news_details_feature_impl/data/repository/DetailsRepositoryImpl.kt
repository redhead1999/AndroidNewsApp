package com.aold.news_details_feature_impl.data.repository

import com.aold.core_db.details.NewsDetailsLocalDataSource
import com.aold.news_details_feature_impl.data.mapper.NewsDetailsDataToDomainMapper
import com.aold.news_details_feature_impl.domain.entities.NewsDetailsEntity
import com.aold.news_details_feature_impl.domain.repository.DetailsRepository
import javax.inject.Inject

/**
 * @author Kirilin Yury on 17.03.2023.
 */

internal class DetailsRepositoryImpl @Inject constructor(
    private val localDataSource: NewsDetailsLocalDataSource,
    private val mapperToDomain: NewsDetailsDataToDomainMapper
) : DetailsRepository {

    override suspend fun fetchNews(): NewsDetailsEntity {
        return localDataSource.read().map(mapperToDomain)
    }
}