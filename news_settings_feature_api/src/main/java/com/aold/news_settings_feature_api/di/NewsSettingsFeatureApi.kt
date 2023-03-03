package com.aold.news_settings_feature_api.di

import com.aold.module_injector.BaseFeatureApi

/**
 * @author Stanislav Aleshin on 24.10.2022.
 */
interface NewsSettingsFeatureApi : BaseFeatureApi {
    fun fetchFeatureStarter(): NewsSettingsFeatureStarter
}