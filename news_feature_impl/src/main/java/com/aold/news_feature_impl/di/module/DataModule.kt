package com.aold.news_feature_impl.di.module

import com.aold.core.core.di.FeatureScope
import com.aold.core.core.handlers.ResponseHandler
import com.aold.news_feature_impl.data.data_sources.network.NewsPagingDataSource
import com.aold.news_feature_impl.data.data_sources.network.NewsRemoteDataSource
import com.aold.news_feature_impl.data.data_sources.network.paging.PagingParamsHandler
import com.aold.news_feature_impl.data.mappers.NewsDataToDomainMapper
import com.aold.news_feature_impl.data.mappers.NewsDetailsDomainToDataMapper
import com.aold.news_feature_impl.data.mappers.NewsResponseToModelMapper
import com.aold.news_feature_impl.data.mappers.ResponseResultMapper
import com.aold.news_feature_impl.data.models.NewsModel
import com.aold.news_feature_impl.data.models.NewsResponse
import com.aold.news_feature_impl.data.repositories.DetailsRepositoryImpl
import com.aold.news_feature_impl.data.repositories.NewsRepositoryImpl
import com.aold.news_feature_impl.data.repositories.SettingsRepositoryImpl
import com.aold.news_feature_impl.domain.repositories.DetailsRepository
import com.aold.news_feature_impl.domain.repositories.NewsRepository
import com.aold.news_feature_impl.domain.repositories.SettingsRepository
import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 14.03.2023.
 */

@Module
internal interface DataModule {

    @Binds
    @FeatureScope
    fun provideNewsRepository(repository: NewsRepositoryImpl): NewsRepository

    @Binds
    @FeatureScope
    fun provideNewsPagingDataSource(dataSource: NewsPagingDataSource.Base): NewsPagingDataSource

    @Binds
    @FeatureScope
    fun provideNewsRemoteDataSource(dataSource: NewsRemoteDataSource.Base): NewsRemoteDataSource

    @Binds
    fun provideResponseResultMapper(mapper: ResponseResultMapper.Base<NewsModel>): ResponseResultMapper<NewsModel>

    @Binds
    fun provideNewsResponseHandler(handle: ResponseHandler.Base<NewsResponse>): ResponseHandler<NewsResponse>

    @Binds
    fun provideNewsResponseToModelMapper(mapper: NewsResponseToModelMapper.Base): NewsResponseToModelMapper

    @Binds
    fun providePagingParamsHandler(handle: PagingParamsHandler.Base): PagingParamsHandler

    @Binds
    @FeatureScope
    fun provideDetailsRepository(repository: DetailsRepositoryImpl): DetailsRepository

    @Binds
    @FeatureScope
    fun provideSettingsRepository(repository: SettingsRepositoryImpl): SettingsRepository

    @Binds
    fun provideNewsDataToDomainMapper(mapper: NewsDataToDomainMapper.Base): NewsDataToDomainMapper

    @Binds
    fun provideNewsDetailsDomainToDataMapper(mapper: NewsDetailsDomainToDataMapper.Base): NewsDetailsDomainToDataMapper
}