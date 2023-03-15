package com.aold.news_feature_impl.navigation

import com.aold.news_details_feature_api.NewsDetailsFeatureStarter
import javax.inject.Inject

/**
 * @author Kirilin Yury on 15.03.2023.
 */

internal interface NavigationManager {

    fun showDetailsScreen()

    class Base @Inject constructor(
        private val detailsFutureStarter: NewsDetailsFeatureStarter
    ) : NavigationManager {
        override fun showDetailsScreen() {
            detailsFutureStarter.showFeature()
        }
    }

}