package com.aold.news_feature_impl.di.holder

import com.aold.module_injector.ComponentHolder
import com.aold.news_feature_api.NewsFeatureApi
import com.aold.news_feature_impl.di.NewsFeatureDependencies
import com.aold.news_feature_impl.di.component.NewsComponent

/**
 * @author Kirilin Yury on 28.02.2023.
 */

object NewsComponentHolder : ComponentHolder<NewsFeatureApi, NewsFeatureDependencies> {
    private var newsComponent: NewsComponent? = null

    override fun initComponent(dependencies: NewsFeatureDependencies) {
        if (newsComponent == null) {
            newsComponent = NewsComponent.create(dependencies)
        }
    }

    internal fun fetchComponent(): NewsComponent {
        return checkNotNull(newsComponent) { "News component is not initializing" }
    }

    override fun fetchApi(): NewsFeatureApi {
        return fetchComponent()
    }

    override fun reset() {
        newsComponent = null
    }
}