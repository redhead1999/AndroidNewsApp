package com.aold.core.core.platform.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aold.core.core.managers.CoroutineBlock
import com.aold.core.core.managers.CoroutineManager
import javax.inject.Provider

/**
 * @author Kirilin Yury on 26.02.2023.
 */

abstract class BaseViewModel(
    protected val coroutineManager: CoroutineManager
) : ViewModel() {

    fun runOnBackground(block: CoroutineBlock) {
        coroutineManager.runOnBackground(viewModelScope, block)
    }

    fun runOnMain(block: CoroutineBlock) {
        coroutineManager.runOnMain(viewModelScope, block)
    }

    abstract class BaseViewModelFactory(
        private val viewModel: Provider<out ViewModel>
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModel.get() as T
        }
    }
}