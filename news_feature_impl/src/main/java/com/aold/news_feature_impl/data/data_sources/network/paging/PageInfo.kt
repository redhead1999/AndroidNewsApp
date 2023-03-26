package com.aold.news_feature_impl.data.data_sources.network.paging

/**
 * @author Kirilin Yury on 27.02.2023.
 */

internal data class PageInfo(
    val current: Int,
    val next: Int?,
    val prev: Int?,
    val size: Int,
)