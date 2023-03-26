package com.aold.news_feature_impl.data.models

/**
 * @author Kirilin Yury on 27.02.2023.
 */

internal data class NewsModel(
    val title: String? = null,
    val description: String? = null,
    val content: String? = null,
    val sourceUrl: String? = null,
    val image: String? = null,
    val publishedAt: String? = null,
    val sourceName: String? = null,
    val baseSourceUrl: String? = null
)