package com.aold.news_favorites_feature_impl.di

import com.aold.module_injector.BaseFeatureDependencies
import com.github.terrakok.cicerone.Router


/**
 * @author Kirilin Yury on 26.03.2023.
 */

interface NewsFavoritesFeatureDependencies : BaseFeatureDependencies {
    val globalRouter: Router
}