package com.aold.news_feature_impl.domain.interactors

import com.aold.core.core.functional.EitherLeft
import com.aold.news_feature_impl.domain.common.NewsEitherWrapper
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.domain.entities.NewsFailures
import com.aold.news_feature_impl.domain.repositories.DetailsRepository
import javax.inject.Inject

/**
 * @author Kirilin Yury on 10.03.2023.
 */

internal interface DetailsInteractor {

    suspend fun saveNews(news: NewsEntity): EitherLeft<NewsFailures>

    class Base @Inject constructor(
        private val detailsRepository: DetailsRepository,
        private val eitherWrapper: NewsEitherWrapper
    ) : DetailsInteractor {

        override suspend fun saveNews(news: NewsEntity) = eitherWrapper.wrap {
            detailsRepository.setNews(news)
        }
    }
}