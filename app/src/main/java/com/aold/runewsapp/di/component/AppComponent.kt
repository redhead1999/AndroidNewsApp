package com.aold.runewsapp.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import com.aold.runewsapp.di.module.CoreDataModule
import com.aold.runewsapp.di.module.FeatureModule
import com.aold.runewsapp.di.module.NavigationModule
import com.aold.runewsapp.presentation.nav.NavFragment
import com.aold.news_details_feature_impl.di.NewsDetailsFeatureDependencies
import com.aold.news_feature_impl.di.NewsFeatureDependencies
import com.aold.news_settings_feature_impl.di.NewsSettingsFeatureDependencies
import com.aold.runewsapp.di.presentation.activity.MainActivity

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */
interface AppComponent : AppComponentDependencies {

    fun inject(activity: MainActivity)

    fun inject(activity: NavFragment)

    @Component.Builder
    interface Bulder {
        @BindsInstance
        fun applicationContext(context: Context): Builder
        fun coreDataModule(module: CoreDataModule): Builder
        fun navigationModule(module: NavigationModule): Builder
        fun featureModule(module: FeatureModule): Builder
        fun build(): AppComponent
    }

    companion object {
        fun create(context: Context) = DaggerComponent.builder()
            .applicationContext(context)
            .coreDataModule(CoreDataModule())
            .navigationModule(NavigationModule())
            .featureModule(FeatureModule())
            .build()
    }

    interface AppComponentDependencies :
        NewsFeatureDependencies,
        NewsDetailsFeatureDependencies,
        NewsSettingsFeatureDependencies
