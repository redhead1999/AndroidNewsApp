package com.aold.news_feature_impl.domain.entities

/**
 * @author {Kirilin Yury} on 01.03.2023.
 */

internal sealed class NewsFailures {

    object NetworkException : NewsFailures()

    object ServiceException : NewsFailures()

    object DataBaseException : NewsFailures()

    data class OtherException(val throwable: Throwable) : NewsFailures()
}