package com.aold.news_feature_impl.navigation

import com.aold.core.core.navigations.BottomNavRouter
import com.aold.news_feature_api.NewsFeatureStarter
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 08.10.2022.
 */
internal class NewsFeatureStarterImpl @Inject constructor(
    private val navRouter: BottomNavRouter
) : NewsFeatureStarter {

    override fun showFeature() {
        navRouter.selectBottomTabScreen(NewsRoutingScreen.fetchNewsScreen())
    }
}