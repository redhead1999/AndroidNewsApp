package com.aold.news_feature_impl.domain.common

import com.aold.core.core.handlers.EitherFailureWrapper
import com.aold.news_feature_impl.domain.entities.NewsFailures
import javax.inject.Inject

/**
 * @author Kirilin Yury on 14.03.2023.
 */

internal interface NewsEitherWrapper : EitherFailureWrapper<NewsFailures> {

    class Base @Inject constructor(errorHandler: NewsErrorHandler) : NewsEitherWrapper,
        EitherFailureWrapper.Abstract<NewsFailures>(errorHandler)
}
