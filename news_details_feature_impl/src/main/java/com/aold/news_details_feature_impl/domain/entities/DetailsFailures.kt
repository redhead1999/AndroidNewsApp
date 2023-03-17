package com.aold.news_details_feature_impl.domain.entities

/**
 * @author Kirilin Yury on 17.03.2023.
 */

internal sealed class DetailsFailures {
    class DataBaseException(val exception: Throwable) : DetailsFailures()
    class OtherException(val exception: Throwable) : DetailsFailures()
}