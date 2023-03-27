package com.aold.news_favorites_feature_impl.presentation.ui

import android.os.Bundle
import com.aold.core.core.platform.fragments.BaseFragmentWithViewModel
import com.aold.news_favorites_feature_impl.di.holder.NewsFavoritesComponentHolder
import javax.inject.Inject

/**
 * @author Kirilin Yury on 27.03.2023.
 */

internal class FavoritesFragment :
    BaseFragmentWithViewModel<FavoritesFragmentBinding, FavoritesViewModel>(
        FavoritesFragmentBinding::inflate
    ) {

    @Inject
    lateinit var factory: FavoritesViewModel.Factory

    override fun fetchViewModelClass() = FavoritesViewModel::class.java

    override fun fetchViewModelFactory() = factory

    override fun initDI() {
        super.initDI()
        NewsFavoritesComponentHolder.fetchComponent().inject(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }
}