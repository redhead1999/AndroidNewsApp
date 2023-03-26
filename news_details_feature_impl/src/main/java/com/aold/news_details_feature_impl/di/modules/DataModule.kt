package com.aold.news_details_feature_impl.di.modules

import com.aold.core.core.di.FeatureScope
import com.aold.news_details_feature_impl.data.mapper.NewsDetailsDataToDomainMapper
import com.aold.news_details_feature_impl.data.repository.DetailsRepositoryImpl
import com.aold.news_details_feature_impl.domain.repository.DetailsRepository

/**
 * @author Kirilin Yury on 18.03.2023.
 */

@Module
internal interface DataModule {

    @Binds
    @FeatureScope
    fun provideDetailsRepository(repository: DetailsRepositoryImpl): DetailsRepository

    @Binds
    @FeatureScope
    fun provideNewsDetailsDataToDomainMapper(mapper: NewsDetailsDataToDomainMapper.Base): NewsDetailsDataToDomainMapper
}