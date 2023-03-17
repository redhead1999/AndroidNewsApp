package com.aold.news_details_feature_impl.domain.entities

import com.aold.core.core.common.Mapper

/**
 * @author Kirilin Yury on 17.03.2023.
 */

data class NewsDetailsEntity(
    val content: String,
    val source: String,
    val sourceUrl: String,
    val imageUrl: String,
    val publishedAt: String,
) {
    fun <T> map(mapper: Mapper<NewsDetailsEntity, T>) = mapper.map(this)
}