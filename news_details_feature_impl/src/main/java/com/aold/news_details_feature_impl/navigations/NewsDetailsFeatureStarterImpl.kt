package com.aold.news_details_feature_impl.navigations

import com.aold.core.core.navigations.GlobalRouter
import com.aold.news_details_feature_api.NewsDetailsFeatureStarter
import javax.inject.Inject

/**
 * @author Kirilin Yury on 18.03.2023.
 */

internal class NewsDetailsFeatureStarterImpl @Inject constructor(
    private val globalRouter: GlobalRouter
) : NewsDetailsFeatureStarter {
    override fun showFeature() {
        globalRouter.navigateTo(NewsDetailsRoutingScreen.fetchDetailsScreen())
    }


}