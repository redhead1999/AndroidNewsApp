package com.aold.news_details_feature_impl.domain.common

import com.aold.core.core.handlers.EitherFailureWrapper
import com.aold.news_details_feature_impl.domain.entities.DetailsFailures
import javax.inject.Inject

/**
 * @author Kirilin Yury on 17.03.2023.
 */

internal interface NewsDetailsEitherWrapper : EitherFailureWrapper<DetailsFailures> {

    class Base @Inject constructor(errorHandler: DetailsErrorHandler) : NewsDetailsEitherWrapper,
        EitherFailureWrapper.Abstract<DetailsFailures>(errorHandler)
}