package com.aold.news_favorites_feature_impl.di.holder

import com.aold.module_injector.ComponentHolder
import com.aold.news_favorites_feature_api.NewsFavoritesFeatureApi
import com.aold.news_favorites_feature_impl.di.NewsFavoritesFeatureDependencies
import com.aold.news_favorites_feature_impl.di.component.NewsFavoritesComponent

/**
 * @author Kirilin Yury on 27.03.2023.
 */

object NewsFavoritesComponentHolder :
    ComponentHolder<NewsFavoritesFeatureApi, NewsFavoritesFeatureDependencies> {

    private var newsFavoritesComponent: NewsFavoritesComponent? = null

    override fun initComponent(dependencies: NewsFavoritesFeatureDependencies) {
        if (newsFavoritesComponent == null) {
            newsFavoritesComponent = NewsFavoritesComponent.create(dependencies)
        }
    }

    internal fun fetchComponent(): NewsFavoritesComponent {
        return checkNotNull(newsFavoritesComponent) { "NewsFavoritesComponent is not initializing" }
    }

    override fun fetchApi(): NewsFavoritesFeatureApi {
        return fetchComponent()
    }

    override fun reset() {
        newsFavoritesComponent = null
    }
}