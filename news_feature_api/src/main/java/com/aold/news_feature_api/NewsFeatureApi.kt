package com.aold.news_feature_api

import com.aold.module_injector.BaseFeatureApi

/**
 * @author Kirilin Yury on 27.02.2023.
 */
interface NewsFeatureApi: BaseFeatureApi{
    fun fetchFeatureStarter(): NewsFeatureStarter

}