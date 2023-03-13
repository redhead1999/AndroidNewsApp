package com.aold.news_feature_impl.domain.common

import com.aold.core.core.handlers.ErrorHandler
import com.aold.core_db.exceptions.StorageExceptions
import com.aold.news_feature_impl.domain.entities.NewsFailures
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * @author Kirilin Yury on 14.03.2023.
 */

internal interface NewsErrorHandler : ErrorHandler<NewsFailures> {

    class Base @Inject constructor() : NewsErrorHandler {
        override fun handle(throwable: Throwable): NewsFailures = when (throwable) {
            is UnknownHostException -> NewsFailures.NetworkException
            is InterruptedIOException -> NewsFailures.NetworkException
            is HttpException -> NewsFailures.ServiceException
            is StorageExceptions -> NewsFailures.DataBaseException
            else -> NewsFailures.OtherException(throwable)
        }
    }
}