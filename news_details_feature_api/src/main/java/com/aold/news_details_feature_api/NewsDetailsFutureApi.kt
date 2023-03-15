package com.aold.news_details_feature_api

import com.aold.module_injector.BaseFeatureApi

/**
 * @author Kirilin Yury on 15.03.2023.
 */
internal interface NewsDetailsFutureApi : BaseFeatureApi {
    fun fetchFeatureStarter(): NewsDetailsFeatureStarter
}