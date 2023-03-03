package com.aold.news_feature_impl.data.mappers

import com.aold.core.core.common.Mapper
import com.aold.news_feature_impl.data.models.NewsModel
import com.aold.news_feature_impl.data.models.NewsResponse

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */

internal interface NewsResponseToDomainMapper : Mapper<NewsResponse, List<NewsModel>> {

    override fun map(input: NewsResponse) = input.articles.map {
        NewsModel(
            title = it.title,
            description = it.description,
            content = it.content,
            sourceUrl = it.url,
            image = it.image,
            publishedAt = it.publishedAt,
            sourceName = it.source?.name,
            baseSourceUrl = it.source?.url
        )
    }
}