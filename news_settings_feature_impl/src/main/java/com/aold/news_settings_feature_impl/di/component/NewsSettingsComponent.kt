package com.aold.news_settings_feature_impl.di.component

import com.aold.core.core.di.FeatureScope
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureApi
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureStarter
import com.aold.news_settings_feature_impl.di.modules.NewsSettingsFeatureDependencies
import dagger.Component

/**
 * @author {Kirilin Yury} on 03.03.2023.
 */

@FeatureScope
@Component(
    dependencies = [NewsSettingsFeatureDependencies::class],
    modules = [
        UtilsModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
        ViewModelModule::class
    ]
)


internal interface NewsSettingsComponent : NewsSettingsFeatureApi {

    override fun fetchFeatureStarter(): NewsSettingsFeatureStarter

    fun inject(fragment: SettingsFragment)

    fun inject(dialogFragment: CategoriesDialogFragment)

    fun inject(dialogFragment: LanguagesDialogFragment)

    fun inject(dialogFragment: CountriesDialogFragment)

    @Component.Builder
    interface Builder {
        fun featureDependencies(dependencies: NewsSettingsFeatureDependencies): Builder
        fun utilsModule(module: UtilsModule): Builder
        fun build(): NewsSettingsComponent
    }

    companion object {
        fun create(dependencies: NewsSettingsFeatureDependencies): NewsSettingsComponent {
            return DaggerNewsSettingsComponnent.builder()
                .featureDependencies(dependencies)
                .utilsModule(UtilsModule())
                .build()
        }
    }
}