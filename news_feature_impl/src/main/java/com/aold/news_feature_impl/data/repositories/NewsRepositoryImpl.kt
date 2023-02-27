package com.aold.news_feature_impl.data.repositories

import com.aold.news_feature_impl.data.data_sources.network.NewsPagingDataSource
import com.aold.news_feature_impl.domain.repositories.NewsRepository
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

internal class NewsRepositoryImpl @Inject constructor(
    private val pagingDataSource: NewsPagingDataSource,
    private val mapperToDomain: NewsDataToDomainMapper
) : NewsRepository {

    override fun
}
