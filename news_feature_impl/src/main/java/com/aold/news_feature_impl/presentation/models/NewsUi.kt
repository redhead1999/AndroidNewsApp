package com.aold.news_feature_impl.presentation.models

import com.aold.core.core.common.Mapper

/**
 * @author Kirilin Yury on 02.03.2023.
 */

internal data class NewsUi(
    val title: String,
    val content: String,
    val source: String,
    val sourceUrl: String,
    val imageUrl: String,
    val publishedAt: String,
) {
    fun <T> map(mapper: Mapper<NewsUi, T>) = mapper.map(this)
}