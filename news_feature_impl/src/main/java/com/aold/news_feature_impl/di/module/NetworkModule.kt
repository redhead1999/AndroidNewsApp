package com.aold.news_feature_impl.di.module

import android.content.Context
import androidx.paging.PagingConfig
import androidx.viewbinding.BuildConfig
import com.aold.core.core.di.FeatureScope
import com.aold.news_feature_impl.data.data_sources.network.NewsPagingDataSource
import com.aold.news_feature_impl.data.data_sources.network.service.NewsInterceptor
import com.aold.news_feature_impl.di.annotation.LoggingInterceptor
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author Kirilin Yury on 10.03.2023.
 */

internal class NetworkModule {
    @Provides
    @FeatureScope
    fun provideNewsPagingConfig(): PagingConfig {
        return PagingConfig(
            pageSize = NewsPagingDataSource.PAGE_SIZE,
            enablePlaceholders = true
        )
    }

    fun provideNewsInterceptor(context: Context): Interceptor {
        return if (BuildConfig.DEBUG) NewsInterceptor.Mock(context) else NewsInterceptor.Base()
    }

    @Provides
    @FeatureScope
    @LoggingInterceptor
    fun provideHttpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(
            if(BuildConfig.DEBUG) Level.BODY,
                else Level.NONE
        )
    }


}