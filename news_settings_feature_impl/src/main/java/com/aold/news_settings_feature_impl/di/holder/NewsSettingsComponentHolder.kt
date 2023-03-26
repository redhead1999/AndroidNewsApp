package com.aold.news_settings_feature_impl.di.holder

import com.aold.module_injector.ComponentHolder
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureApi
import com.aold.news_settings_feature_impl.di.component.NewsSettingsComponent
import com.aold.news_settings_feature_impl.di.modules.NewsSettingsFeatureDependencies

object NewsSettingsComponentHolder :
    ComponentHolder<NewsSettingsFeatureApi, NewsSettingsFeatureDependencies> {

    private var newsSettingsComponent: NewsSettingsComponent? = null

    override fun initComponent(dependencies: NewsSettingsFeatureDependencies) {
        if (newsSettingsComponent == null) {
            newsSettingsComponent = NewsSettingsComponent.create(dependencies)
        }
    }

    internal fun fetchComponent(): NewsSettingsComponent {
        return checkNotNull(newsSettingsComponent) { "NewsSettingsComponent is not initializing " }
    }

    override fun fetchApi(): NewsSettingsFeatureApi {
        return fetchComponent()
    }

    override fun reset() {
        newsSettingsComponent = null
    }
}