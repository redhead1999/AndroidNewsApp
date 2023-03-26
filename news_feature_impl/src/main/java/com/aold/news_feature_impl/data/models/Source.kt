package com.aold.news_feature_impl.data.models

import com.google.gson.annotations.SerializedName

/**
 * @author Kirilin Yury on 27.02.2023.
 */

data class Source(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null
)