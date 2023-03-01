package com.aold.news_feature_impl.presentation.mappers

import com.aold.core.core.common.Mapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.presentation.models.NewsUi
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 02.03.2023.
 */
internal interface NewsDomainToUiMapper : Mapper<NewsEntity, NewsUi> {

    class Base @Inject constructor() : NewsDomainToUiMapper {
        override fun map(input: NewsEntity) = NewsUi(
            title = input.title,
            content = input.content,
            source = input.source,
            sourceUrl = input.sourceUrl,
            imageUrl = input.image,
            publishedAt = input.publishedAt
        )
    }
}