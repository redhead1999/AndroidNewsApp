package com.aold.news_feature_impl.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author Kirilin Yury on 27.02.2023.
 */

internal data class NewsResponse(
    @SerializedName("totalArticles") val totalArticles: Int? = null,
    @SerializedName("articles") val articles: List<Articles> = listOf()
)
