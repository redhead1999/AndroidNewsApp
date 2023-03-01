package com.aold.news_feature_impl.domain.repositories

import androidx.paging.PagingData
import com.aold.news_feature_impl.domain.entities.NewsEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

internal interface NewsRepository {
    fun fetchNews(category: String, language: String, country: String): Flow<PagingData<NewsEntity>>
}