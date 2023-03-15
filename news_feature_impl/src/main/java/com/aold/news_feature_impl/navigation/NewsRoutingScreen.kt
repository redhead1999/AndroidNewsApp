package com.aold.news_feature_impl.navigation

import com.aold.news_feature_impl.presentation.ui.news.NewsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * @author Kirilin Yury on 15.03.2023.
 */

internal object NewsRoutingScreen {

    fun fetchNewsScreen() = FragmentScreen(NavigationKeys.NEWS_FRAGMENT) {
        NewsFragment()
    }

    internal object NavigationKeys {
        const val NEWS_FRAGMENT = "NewsFragment"
    }
}