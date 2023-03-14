package com.aold.news_feature_impl.presentation.ui.news.communications

import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import com.aold.news_feature_impl.presentation.models.NewsUi
import com.aold.news_feature_impl.presentation.ui.news.common.NewsUiState
import kotlinx.coroutines.flow.FlowCollector

/**
 * @author Kirilin Yury on 14.03.2023.
 */

internal interface NewsCommunicationsCollect {

    fun collectState(
        lifecycleOwner: LifecycleOwner,
        collector: FlowCollector<NewsUiState>
    )

    fun collectNews(
        lifecycleOwner: LifecycleOwner,
        collector: FlowCollector<PagingData<NewsUi>>
    )
}