package com.aold.news_settings_feature_api.di

import com.aold.module_injector.BaseFeatureApi

/**
 * @author Kirilin Yury on 10.03.2023.
 */

interface NewsSettingsFeatureApi : BaseFeatureApi {
    fun fetchFeatureStarter(): NewsSettingsFeatureStarter
}