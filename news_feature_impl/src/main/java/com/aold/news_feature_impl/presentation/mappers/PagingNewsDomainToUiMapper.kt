package com.aold.news_feature_impl.presentation.mappers

import androidx.paging.PagingData
import androidx.paging.map
import com.aold.core.core.common.Mapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.presentation.models.NewsUi
import javax.inject.Inject

/**
 * @author {Kirilin Yury} on 02.03.2023.
 */

internal interface PagingNewsDomainToUiMapper : Mapper<PagingData<NewsEntity>, PagingData<NewsUi>> {

    class Base @Inject constructor(
        private val mapperToUi: NewsDomainToUiMapper
    ) : PagingNewsDomainToUiMapper {

        override fun map(input: PagingData<NewsEntity>): PagingData<NewsUi> {
            return input.map { newsDomain -> newsDomain.map(mapperToUi) }
        }
    }
}