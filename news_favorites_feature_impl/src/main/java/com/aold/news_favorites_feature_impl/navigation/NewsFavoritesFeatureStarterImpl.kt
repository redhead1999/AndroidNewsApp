package com.aold.news_favorites_feature_impl.navigation

import com.aold.news_favorites_feature_api.NewsFavoritesFeatureStarter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.03.2023.
 */

internal class NewsFavoritesFeatureStarterImpl @Inject constructor(
    private val globalRouter: Router
) : NewsFavoritesFeatureStarter {

    override fun show() {
        globalRouter.navigateTo(NewsFavoritesRoutingScreen.fetchFavoritesScreen())
    }
}