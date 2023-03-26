package com.aold.news_feature_impl.di.component

import com.aold.core.core.di.FeatureScope
import com.aold.news_feature_api.NewsFeatureApi
import com.aold.news_feature_impl.di.NewsFeatureDependencies
import com.aold.news_feature_impl.di.module.DataModule
import com.aold.news_feature_impl.di.module.DomainModule
import com.aold.news_feature_impl.di.module.NetworkModule
import com.aold.news_feature_impl.presentation.ui.news.NewsFragment
import dagger.Component
import ru.aleshin.news_feature_impl.di.module.PresentationModule
import ru.aleshin.news_feature_impl.di.module.UtilsModule
import com.aold.news_feature_impl.di.module.ViewModelModule

/**
 * @author Kirilin Yury on 27.02.2023.
 */

@FeatureScope
@Component(
    dependencies = [NewsFeatureDependencies::class],
    modules = [
        UtilsModule::class,
        NetworkModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
        ViewModelModule::class
    ]
)
internal interface NewsComponent : NewsFeatureApi {

    fun inject(fragment: NewsFragment)

    @Component.Builder
    interface Builder {
        fun featureDependencies(dependencies: NewsFeatureDependencies): Builder
        fun networkModule(module: NetworkModule): Builder
        fun utilsModule(module: UtilsModule): Builder
        fun build(): NewsComponent
    }

    companion object {
        fun create(dependencies: NewsFeatureDependencies): NewsComponent {
            return DaggerNewsComponent.builder()
                .featureDependencies(dependencies)
                .networkModule(NetworkModule())
                .utilsModule(UtilsModule())
                .build()
        }
    }
}