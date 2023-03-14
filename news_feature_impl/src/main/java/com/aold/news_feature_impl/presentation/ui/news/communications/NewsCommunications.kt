package com.aold.news_feature_impl.presentation.ui.news.communications

import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import com.aold.core.core.platform.communication.Communicator
import com.aold.core.core.platform.communication.PagingCommunicator
import com.aold.news_feature_impl.presentation.models.NewsUi
import com.aold.news_feature_impl.presentation.ui.news.common.NewsUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 08.10.2022.
 */
internal interface NewsCommunications : NewsCommunicationsCollect {

    fun showState(state: NewsUiState)

    suspend fun fetchState(): NewsUiState

    suspend fun updateNewsFlow(data: Flow<PagingData<NewsUi>>)

    class Base @Inject constructor(
        private val stateCommunication: NewsStateCommunicator,
        private val pagingNewsCommunicator: PagingNewsCommunicator
    ) : NewsCommunications {

        override fun collectState(
            lifecycleOwner: LifecycleOwner,
            collector: FlowCollector<NewsUiState>
        ) = stateCommunication.collect(lifecycleOwner, collector)

        override fun collectNews(
            lifecycleOwner: LifecycleOwner,
            collector: FlowCollector<PagingData<NewsUi>>
        ) = pagingNewsCommunicator.collect(lifecycleOwner, collector)

        override suspend fun updateNewsFlow(data: Flow<PagingData<NewsUi>>) {
            pagingNewsCommunicator.update(data)
        }

        override fun showState(state: NewsUiState) {
            stateCommunication.update(state)
        }

        override suspend fun fetchState() = stateCommunication.read()
    }
}

internal interface NewsStateCommunicator : Communicator.Combined<NewsUiState> {

    class Base @Inject constructor() : NewsStateCommunicator,
        Communicator.AbstractStateFlow<NewsUiState>(NewsUiState.Empty)
}

internal interface PagingNewsCommunicator : PagingCommunicator<NewsUi> {

    class Base @Inject constructor() : PagingNewsCommunicator,
        PagingCommunicator.Abstract<NewsUi>()
}