package com.aold.news_feature_impl.di.module

import com.aold.core.core.di.FeatureScope
import com.aold.news_feature_impl.domain.common.NewsEitherWrapper
import com.aold.news_feature_impl.domain.common.NewsErrorHandler
import com.aold.news_feature_impl.domain.common.SettingsEitherToEntityMapper
import com.aold.news_feature_impl.domain.interactors.DetailsInteractor
import com.aold.news_feature_impl.domain.interactors.NewsInteractor
import dagger.Binds
import dagger.Module


/**
 * @author Kirilin Yury on 28.02.2023.
 */


@Module
internal interface DomainModule {

    @Binds
    @FeatureScope
    fun provideNewsInteractor(newsInteractor: NewsInteractor.Base): NewsInteractor

    @Binds
    @FeatureScope
    fun provideDetailsInteractor(newsInteractor: DetailsInteractor.Base): DetailsInteractor

    @Binds
    fun provideSettingsEitherWrapper(wrapper: NewsEitherWrapper.Base): NewsEitherWrapper

    @Binds
    fun provideSettingsEitherToEntityMapper(mapper: SettingsEitherToEntityMapper.Base): SettingsEitherToEntityMapper

    @Binds
    fun provideNewsFeatureErrorHandler(handler: NewsErrorHandler.Base): NewsErrorHandler
}