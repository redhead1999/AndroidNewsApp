package com.aold.news_details_feature_impl.navigations

import android.content.Intent
import android.net.Uri
import com.aold.core.core.navigations.GlobalRouter
import javax.inject.Inject

/**
 * @author Kirilin Yury on 17.03.2023.
 */

internal interface NavigationManager {

    fun navigateToSharingScreen(newsUrl: String)

    fun navigateToNewsUrl(newsUrl: String)

    fun navigateToBackScreen()

    class Base @Inject constructor(
        private val globalRouter: GlobalRouter
    ) : NavigationManager {

        override fun navigateToSharingScreen(newsUrl: String) {
            val sharingIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, newsUrl)
            }
            globalRouter.showIntent(Intent.createChooser(sharingIntent, "Share"))
        }

        override fun navigateToNewsUrl(newsUrl: String) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl))
            globalRouter.showIntent(intent)
        }

        override fun navigateToBackScreen() {
            globalRouter.exit()
        }
    }
}