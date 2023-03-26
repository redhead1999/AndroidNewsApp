package com.aold.news_feature_impl.domain.entities

import com.aold.core.core.common.Mapper

/**
 * @author Kirilin Yury on 01.03.2023.
 */
internal data class NewsEntity(
    val title: String,
    val content: String,
    val source: String,
    val sourceUrl: String,
    val image: String,
    val publishedAt: String
) {
    fun <T> map(mapper: Mapper<NewsEntity, T>) = mapper.map(this)
}
