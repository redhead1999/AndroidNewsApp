package com.aold.news_favorites_feature_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.aold.news_favorites_feature_impl.presentation.ui.FavoritesFragment

/**
 * @author Kirilin Yury on 27.03.2023.
 */

internal object NewsFavoritesRoutingScreen {
    fun fetchFavoritesScreen() = FragmentScreen { FavoritesFragment() }
}