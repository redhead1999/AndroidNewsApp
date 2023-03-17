package com.aold.news_details_feature_impl.domain.repository

import com.aold.news_details_feature_impl.domain.entities.NewsDetailsEntity

/**
 * @author Kirilin Yury on 17.03.2023.
 */
internal interface DetailsRepository {
    suspend fun fetchNews(): NewsDetailsEntity
}