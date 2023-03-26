package com.aold.news_feature_impl.data.mappers

import com.aold.core.core.common.Mapper
import com.aold.core.core.managers.DateManager
import com.aold.news_feature_impl.data.models.NewsModel
import com.aold.news_feature_impl.domain.entities.NewsEntity
import javax.inject.Inject

/**
 * @author Kirilin Yury on 01.03.2023.
 */
internal interface NewsDataToDomainMapper : Mapper<NewsModel, NewsEntity> {

    class Base @Inject constructor(private val dateManager: DateManager) : NewsDataToDomainMapper {

        override fun map(input: NewsModel) = NewsEntity(
            title = checkNotNull(input.title),
            content = checkNotNull(input.description),
            source = checkNotNull(input.sourceName),
            sourceUrl = checkNotNull(input.sourceUrl),
            image = checkNotNull(input.image),
            publishedAt = dateManager.parseIsoInstant(checkNotNull(input.publishedAt))
        )
    }
}