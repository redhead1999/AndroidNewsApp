package com.aold.news_favorites_feature_impl.di.component

import com.aold.core.core.di.FeatureScope
import com.aold.news_favorites_feature_api.NewsFavoritesFeatureApi
import com.aold.news_favorites_feature_api.NewsFavoritesFeatureStarter
import dagger.Component
import com.aold.news_favorites_feature_impl.di.NewsFavoritesFeatureDependencies
import com.aold.news_favorites_feature_impl.di.modules.UtilsModule
import com.aold.news_favorites_feature_impl.di.modules.ViewModelModule
import com.aold.news_favorites_feature_impl.presentation.ui.FavoritesFragment

/**
 * @author Kirilin Yury on 27.03.2023.
 */

@FeatureScope
@Component(
    dependencies = [NewsFavoritesFeatureDependencies::class],
    modules = [UtilsModule::class, ViewModelModule::class]
)
internal interface NewsFavoritesComponent : NewsFavoritesFeatureApi {

    override fun fetchFeatureStarter(): NewsFavoritesFeatureStarter

    fun inject(fragment: FavoritesFragment)

    @Component.Builder
    interface Builder {
        fun featureDependencies(dependencies: NewsFavoritesFeatureDependencies): Builder
        fun build(): NewsFavoritesComponent
    }

    companion object {
        fun create(dependencies: NewsFavoritesFeatureDependencies): NewsFavoritesComponent {
            return DaggerNewsFavoritesComponent.builder()
                .featureDependencies(dependencies)
                .build()
        }
    }
}