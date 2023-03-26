package com.aold.news_feature_impl.data.mappers

import com.aold.core.core.common.Mapper
import com.aold.core_db.details.NewsDetailsModel
import com.aold.news_feature_impl.domain.entities.NewsEntity
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */
internal interface NewsDetailsDomainToMapper : Mapper<NewsEntity, NewsDetailsModel> {

    class Base @Inject constructor() : NewsDetailsDomainToMapper {

        override fun map(input: NewsEntity) = NewsDetailsModel(
            content = input.content,
            source = input.source,
            sourceUrl = input.sourceUrl,
            imageUrl = input.image,
            publishedAt = input.publishedAt
        )
    }
}