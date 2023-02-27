package com.aold.news_feature_impl.data.data_sources.network.service

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

internal data class NewsRequest(
    val category: String,
    val language: String,
    val country: String
)
