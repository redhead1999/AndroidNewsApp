package com.aold.news_feature_impl.presentation.ui.news.common

import androidx.paging.PagingData
import com.aold.core.core.functional.Either
import com.aold.core.core.managers.CoroutineManager
import com.aold.news_feature_impl.domain.entities.NewsEntity
import com.aold.news_feature_impl.domain.entities.NewsFailures
import com.aold.news_feature_impl.presentation.mappers.PagingNewsDomainToUiMapper
import com.aold.news_feature_impl.presentation.ui.news.communications.NewsCommunications
import com.aold.news_settings_feature_api.domain.SettingsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author Kirilin Yury on 14.03.2023.
 */
internal interface NewsRequestHandler {

    fun handleFlowPaging(
        scope: CoroutineScope,
        block: suspend () -> Flow<PagingData<NewsEntity>>
    )

    fun handleEitherSettings(
        scope: CoroutineScope,
        block: suspend () -> Either<NewsFailures, SettingsEntity>
    )

    class Base @Inject constructor(
        private val coroutineManager: CoroutineManager,
        private val communications: NewsCommunications,
        private val pagingDomainToUiMapper: PagingNewsDomainToUiMapper
    ) : NewsRequestHandler {
        override fun handleFlowPaging(
            scope: CoroutineScope,
            block: suspend () -> Flow<PagingData<NewsEntity>>
        ) = coroutineManager.runOnBackground(scope) {
            communications.updateNewsFlow(block.invoke().map { pagingDomainToUiMapper.map(it) })
        }

        override fun handleEitherSettings(
            scope: CoroutineScope,
            block: suspend () -> Either<NewsFailures, SettingsEntity>
        ) = coroutineManager.runOnBackground(scope) {
            when (val settingsEither = block.invoke()) {
                is Either.Right -> {
                    communications.showState(NewsUiState.Init(settingsEither.data.defaultCategory))
                }
                is Either.Left -> {
                    communications.showState(NewsUiState.Init(SettingsEntity.DEFUALT_CATEGORY))
                }
            }
        }
    }
}