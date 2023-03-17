package com.aold.news_details_feature_impl.di

import com.aold.core.core.navigations.GlobalRouter
import com.aold.core_db.details.NewsDetailsLocalDataSource
import com.aold.module_injector.BaseFeatureDependencies

/**
 * @author Kirilin Yury on 17.03.2023.
 */
interface NewsDetailsFeatureDependencies : BaseFeatureDependencies {
    val globalRouter: GlobalRouter
    val detailsLocalDataSource: NewsDetailsLocalDataSource
}