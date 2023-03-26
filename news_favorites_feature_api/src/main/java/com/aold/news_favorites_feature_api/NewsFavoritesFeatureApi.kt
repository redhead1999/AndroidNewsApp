package com.aold.news_favorites_feature_api

import com.aold.module_injector.BaseFeatureApi


/**
 * @author Kirilin Yury on 26.03.2023.
 */

interface NewsFavoritesFeatureApi : BaseFeatureApi {
    fun fetchFeatureStarter(): NewsFavoritesFeatureStarter
}