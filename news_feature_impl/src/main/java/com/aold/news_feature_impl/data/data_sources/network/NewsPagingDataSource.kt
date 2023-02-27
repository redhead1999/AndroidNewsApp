package com.aold.news_feature_impl.data.data_sources.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.aold.news_feature_impl.data.data_sources.network.service.NewsRequest
import com.aold.news_feature_impl.data.models.NewsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

internal interface NewsPagingDataSource {

    fun fetchNews(newsRequest: NewsRequest): Flow<PagingData<NewsModel>>

    class Base @Inject constructor(
        private val newsPagingSourceFactory: NewsPagingSource.Factory,
        private val pagingConfig: PagingConfig
    ) : NewsPagingDataSource {

        override fun fetchNews(newsRequest: NewsRequest): Flow<PagingData<NewsModel>> {
            return Pager(
                config = pagingConfig,
                pagingSourceFactory = { newsPagingSourceFactory.create(newsRequest) }
            ).flow
        }
    }

    companion object {
        const val PAGE_SIZE = 10
    }
}