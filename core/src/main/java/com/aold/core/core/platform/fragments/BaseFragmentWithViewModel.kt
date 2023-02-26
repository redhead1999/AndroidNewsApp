package com.aold.core.core.platform.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

abstract class BaseFragmentWithViewModel<VB : ViewBinding, VM : ViewModel>(
    bindingInflater: FragmentBindingInflater<VB>
) : BaseFragment<VB>(bindingInflater) {

    protected val viewModel: VM by lazy {
        ViewModelProvider(this, fetchViewModelFactory())[fetchViewModelClass()]
    }

    abstract fun fetchViewModelClass(): Class<VM>

    abstract fun fetchViewModelFactory(): ViewModelProvider.Factory
}