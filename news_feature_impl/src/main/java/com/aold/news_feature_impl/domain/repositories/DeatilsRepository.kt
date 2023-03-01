package com.aold.news_feature_impl.domain.repositories

import com.aold.news_feature_impl.domain.entities.NewsEntity

/**
 * @author {Kirilin Yury} on 28.02.2023.
 */
internal interface DetailsRepository {
    suspend fun setNews(news: NewsEntity)
}