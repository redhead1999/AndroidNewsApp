package com.aold.news_feature_impl.presentation.ui.news

import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import com.aold.core.core.managers.CoroutineManager
import com.aold.core.core.platform.viewmodel.BaseViewModel
import com.aold.core.core.platform.viewmodel.Init
import com.aold.news_feature_impl.domain.common.NewsErrorHandler
import com.aold.news_feature_impl.domain.interactors.DetailsInteractor
import com.aold.news_feature_impl.domain.interactors.NewsInteractor
import com.aold.news_feature_impl.navigation.NavigationManager
import com.aold.news_feature_impl.presentation.mappers.NewsUiToDomainMapper
import com.aold.news_feature_impl.presentation.models.NewsUi
import com.aold.news_feature_impl.presentation.ui.news.common.NewsRequestHandler
import com.aold.news_feature_impl.presentation.ui.news.common.NewsUiState
import com.aold.news_feature_impl.presentation.ui.news.communications.NewsCommunications
import com.aold.news_feature_impl.presentation.ui.news.communications.NewsCommunicationsCollect
import com.aold.news_settings_feature_api.domain.Categories
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 * @author Kirilin Yury on 15.03.2023.
 */

internal class NewsViewModel @Inject constructor(
    private val newsInteractor: NewsInteractor,
    private val detailsInteractor: DetailsInteractor,
    private val communications: NewsCommunications,
    private val requestHandler: NewsRequestHandler,
    private val navigationManager: NavigationManager,
    private val errorHandler: NewsErrorHandler,
    private val mapperToDomain: NewsUiToDomainMapper,
    coroutineManager: CoroutineManager
) : BaseViewModel(coroutineManager), Init, NewsCommunicationsCollect {

    private var currentCategory: Categories? = null
    override fun init(itFirstStart: Boolean) {
        TODO("Not yet implemented")
    }

    override fun collectState(
        lifecycleOwner: LifecycleOwner,
        collector: FlowCollector<NewsUiState>
    ) {
        TODO("Not yet implemented")
    }

    override fun collectNews(
        lifecycleOwner: LifecycleOwner,
        collector: FlowCollector<PagingData<NewsUi>>
    ) {
        TODO("Not yet implemented")
    }
}