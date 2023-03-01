package com.aold.news_feature_impl.presentation.mappers

import com.aold.core.core.common.Mapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.presentation.models.NewsUi
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 15.10.2022.
 */
internal interface NewsUiToDomainMapper : Mapper<NewsUi, NewsEntity> {

    class Base @Inject constructor() : NewsUiToDomainMapper {
        override fun map(input: NewsUi) = NewsEntity(
            title = input.title,
            content = input.content,
            source = input.source,
            sourceUrl = input.sourceUrl,
            image = input.imageUrl,
            publishedAt = input.publishedAt
        )
    }
}