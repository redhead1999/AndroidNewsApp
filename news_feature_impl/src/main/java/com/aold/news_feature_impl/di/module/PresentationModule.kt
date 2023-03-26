package ru.aleshin.news_feature_impl.di.module

import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import com.aold.core.core.platform.adapter.BaseViewHolder
import com.aold.news_feature_impl.presentation.mappers.NewsDomainToUiMapper
import com.aold.news_feature_impl.presentation.mappers.NewsUiToDomainMapper
import com.aold.news_feature_impl.presentation.mappers.PagingNewsDomainToUiMapper
import com.aold.news_feature_impl.presentation.models.NewsUi
import com.aold.news_feature_impl.presentation.ui.news.adapters.NewsAdapter
import com.aold.news_feature_impl.presentation.ui.news.adapters.NewsLoadStateAdapter
import com.aold.news_feature_impl.presentation.ui.news.adapters.NewsViewHolder
import dagger.Binds
import dagger.Module

/**
 * @author Kirilin Yury on 28.02.2023.
 */

@Module
internal interface PresentationModule {

    @Binds
    fun provideNewsUiToDomainMapper(mapper: NewsUiToDomainMapper.Base): NewsUiToDomainMapper

    @Binds
    fun provideNewsDomainToUiMapper(mapper: NewsDomainToUiMapper.Base): NewsDomainToUiMapper

    @Binds
    fun providePagingNewsDomainToUiMapper(mapper: PagingNewsDomainToUiMapper.Base): PagingNewsDomainToUiMapper

    @Binds
    fun provideNewsPagingAdapter(adapter: NewsAdapter): PagingDataAdapter<NewsUi, NewsViewHolder>

    @Binds
    fun provideNewsLoadStatePagingAdapter(adapter: NewsLoadStateAdapter): LoadStateAdapter<BaseViewHolder<LoadState>>
}