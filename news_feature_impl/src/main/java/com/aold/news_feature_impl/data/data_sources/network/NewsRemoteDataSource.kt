package com.aold.news_feature_impl.data.data_sources.network

import com.aold.core.core.functional.ResponseResult
import com.aold.core.core.handlers.ResponseHandler
import com.aold.news_feature_impl.data.data_sources.network.service.NewsRequest
import com.aold.news_feature_impl.data.models.NewsModel
import com.aold.news_feature_impl.data.models.NewsResponse
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

internal interface NewsRemoteDataSource {

    suspend fun fetchNews(newsRequest: NewsRequest, page: Int): ResponseResult<List<NewsModel>>

    class Base @Inject constructor(
        private val service: NewsService,
        private val responseHandler: ResponseHandler<NewsResponse>,
        private val mapperToData: NewsResponseToModelMapper
    ) : NewsRemoteDataSource {

        override suspend fun fetchNews(
            newsRequest: NewsRequest,
            page: Int
        ) = responseHandler.handle {
            service.fetchNews(
                category = newsRequest.category,
                language = newsRequest.language,
                country = newsRequest.country,
                page = page
            )
        }.map { mapperToData.map(it) }
    }
}