package com.aold.news_details_feature_impl.data.mapper

import com.aold.core.core.common.Mapper
import com.aold.core_db.details.NewsDetailsModel
import com.aold.news_details_feature_impl.domain.entities.NewsDetailsEntity
import javax.inject.Inject

/**
 * @author Kirilin Yury on 17.03.2023.
 */

internal interface NewsDetailsDataToDomainMapper : Mapper<NewsDetailsModel, NewsDetailsEntity> {

    class Base @Inject constructor() : NewsDetailsDataToDomainMapper {
        override fun map(input: NewsDetailsModel) = NewsDetailsEntity(
            content = input.content,
            source = input.source,
            sourceUrl = input.sourceUrl,
            imageUrl = input.imageUrl,
            publishedAt = input.publishedAt
        )
    }
}