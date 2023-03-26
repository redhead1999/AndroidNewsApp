package com.aold.core.core.platform.communication

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import com.aold.core.core.extensions.lifecycleCollect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll

/**
 * @author Kirilin Yury on 26.02.2023.
 */

interface PagingCommunicator<T : Any> {

    suspend fun update(block: Flow<PagingData<T>>)

    fun collect(lifecycleOwner: LifecycleOwner, collector: FlowCollector<PagingData<T>>)

    abstract class Abstract<T : Any>(
        defualtData: PagingData<T> = PagingData.empty()
    ) : PagingCommunicator<T> {

        private val pagingFlow = MutableStateFlow(defualtData)

        override suspend fun update(block: Flow<PagingData<T>>) {
            pagingFlow.emitAll(block)
        }

        override fun collect(
            lifecycleOwner: LifecycleOwner,
            collector: FlowCollector<PagingData<T>>
        ) {
            pagingFlow.lifecycleCollect(lifecycleOwner, Lifecycle.State.STARTED, collector)
        }
    }
}