package com.aold.news_details_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.news_details_feature_impl.domain.common.DetailsErrorHandler
import com.aold.news_details_feature_impl.domain.common.NewsDetailsEitherWrapper
import com.aold.news_details_feature_impl.domain.interactor.DetailsInteractor

/**
 * @author Kirilin Yury on 18.03.2023.
 */
@Module
internal interface DomainModule {

    @Binds
    @FeatureScope
    fun provideDetailsInteractor(interactor: DetailsInteractor.Base): DetailsInteractor

    @Binds
    fun provideNewsDetailsEitherWrapper(wrapper: NewsDetailsEitherWrapper.Base): NewsDetailsEitherWrapper

    @Binds
    fun provideDetailsErrorHandler(handler: DetailsErrorHandler.Base): DetailsErrorHandler
}