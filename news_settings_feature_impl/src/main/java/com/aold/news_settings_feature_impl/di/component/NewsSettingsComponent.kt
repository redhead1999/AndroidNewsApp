package com.aold.news_settings_feature_impl.di.component

import com.aold.core.core.di.FeatureScope
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureApi
import com.aold.news_settings_feature_api.di.NewsSettingsFeatureStarter
import com.aold.news_settings_feature_impl.di.modules.*
import com.aold.news_settings_feature_impl.di.modules.DataModule
import com.aold.news_settings_feature_impl.di.modules.DomainModule
import com.aold.news_settings_feature_impl.di.modules.UtilsModule
import com.aold.news_settings_feature_impl.di.modules.ViewModelModule
import com.aold.news_settings_feature_impl.presentation.ui.categories.CategoriesDialogFragment
import com.aold.news_settings_feature_impl.presentation.ui.countries.CountriesDialogFragment
import com.aold.news_settings_feature_impl.presentation.ui.languages.LanguagesDialogFragment
import com.aold.news_settings_feature_impl.presentation.ui.settings.SettingsFragment
import dagger.Component

/**
 * @author Kirilin Yury on 03.03.2023.
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
            return DaggerNewsSettingsComponent.builder()
                .featureDependencies(dependencies)
                .utilsModule(UtilsModule())
                .build()
        }
    }
}