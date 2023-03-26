package com.aold.runewsapp.di.component

import android.content.Context
import com.aold.core.core.di.AppScope
import com.aold.runewsapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import com.aold.runewsapp.presentation.nav.NavFragment
import com.aold.runewsapp.presentation.activity.MainActivity

/**
 * @author Kirilin Yury on 26.02.2023.
 */

@AppScope
@Component(
    modules = [
        UtilsModule::class,
        CoreDataModule::class,
        NavigationModule::class,
        FeatureModule::class,
        FeatureDependenciesModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent : AppComponentDependencies {

    fun inject(activity: MainActivity)

    fun inject(activity: NavFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder
        fun coreDataModule(module: CoreDataModule): Builder
        fun navigationModule(module: NavigationModule): Builder
        fun featureModule(module: FeatureModule): Builder
        fun build(): AppComponent
    }

    companion object {
        fun create(context: Context) = DaggerAppComponent.builder()
            .applicationContext(context)
            .coreDataModule(CoreDataModule())
            .navigationModule(NavigationModule())
            .featureModule(FeatureModule())
            .build()
    }
}

//interface AppComponentDependencies :
//    NewsFeatureDependencies,
//    NewsDetailsFeatureDependencies,
//    NewsSettingsFeatureDependencies