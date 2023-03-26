package com.aold.core_db.details

import com.aold.core.core.common.Mapper

/**
 * @author Kirilin Yury on 27.02.2023.
 */

data class NewsDetailsModel(
    val content: String,
    val source: String,
    val sourceUrl: String,
    val imageUrl: String,
    val publishedAt: String
) {
    fun <T> map(mapper: Mapper<NewsDetailsModel, T>) = mapper.map(this)
}