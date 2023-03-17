package com.aold.news_details_feature_impl.domain.common

import com.aold.core.core.handlers.ErrorHandler
import com.aold.core_db.exceptions.StorageExceptions
import com.aold.news_details_feature_impl.domain.entities.DetailsFailures
import javax.inject.Inject

/**
 * @author Kirilin Yury on 17.03.2023.
 */

internal interface DetailsErrorHandler : ErrorHandler<DetailsFailures> {

    class Base @Inject constructor() : DetailsErrorHandler {

        override fun handle(throwable: Throwable) = when (throwable) {
            is StorageExceptions -> DetailsFailures.DataBaseException(throwable)
            else -> DetailsFailures.OtherException(throwable)
        }
    }
}