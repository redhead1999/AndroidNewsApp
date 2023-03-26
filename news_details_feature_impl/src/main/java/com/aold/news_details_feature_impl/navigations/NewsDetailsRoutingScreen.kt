package com.aold.news_details_feature_impl.navigations


/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal object NewsDetailsRoutingScreen {

    fun fetchDetailsScreen() = FragmentScreen(NavigationKeys.NEWS_DETAILS_FRAGMENT) {
        NewsDetailsFragment()
    }
}

internal object NavigationKeys {
    const val NEWS_DETAILS_FRAGMENT = "NewsDetailsFragment"
}