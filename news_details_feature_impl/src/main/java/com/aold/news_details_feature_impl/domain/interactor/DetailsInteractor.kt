package com.aold.news_details_feature_impl.domain.interactor

import com.aold.core.core.functional.Either
import com.aold.news_details_feature_impl.domain.common.NewsDetailsEitherWrapper
import com.aold.news_details_feature_impl.domain.entities.DetailsFailures
import com.aold.news_details_feature_impl.domain.entities.NewsDetailsEntity
import com.aold.news_details_feature_impl.domain.repository.DetailsRepository
import javax.inject.Inject

/**
 * @author Kirilin Yury on 17.03.2023.
 */
internal interface DetailsInteractor {

    suspend fun fetchNews(): Either<DetailsFailures, NewsDetailsEntity>

    class Base @Inject constructor(
        private val detailsRepository: DetailsRepository,
        private val eitherWrapper: NewsDetailsEitherWrapper
    ) : DetailsInteractor {
        override suspend fun fetchNews() = eitherWrapper.wrap {
            detailsRepository.fetchNews()
        }
    }
}