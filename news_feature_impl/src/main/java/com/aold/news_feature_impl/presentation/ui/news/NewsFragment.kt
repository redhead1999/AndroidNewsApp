package com.aold.news_feature_impl.presentation.ui.news

import android.os.Bundle
import com.aold.core.core.extensions.checkedChipButtonTag
import com.aold.core.core.platform.fragments.BaseFragmentWithViewModel
import com.aold.news_feature_impl.databinding.NewsFragmentBinding
import com.aold.news_feature_impl.di.holder.NewsComponentHolder
import com.aold.news_feature_impl.presentation.ui.news.adapters.NewsAdapter
import com.aold.news_feature_impl.presentation.ui.news.adapters.NewsLoadStateAdapter
import com.aold.news_settings_feature_api.domain.convertToCategory
import javax.inject.Inject

/**
 * @author Kirilin Yury on 15.03.2023.
 */

internal class NewsFragment : BaseFragmentWithViewModel<NewsFragmentBinding, NewsViewModel>(
    NewsFragmentBinding::inflate
) {

    @Inject
    lateinit var factory: NewsViewModel.Factory

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var loadStateAdapter: NewsLoadStateAdapter

    override fun initDI() = NewsComponentHolder.fetchComponent().inject(this)

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        viewModel.init(savedInstanceState == null)

        viewModel.collectState(viewLifecycleOwner) { state -> state.apply(requireViewBinding()) }

        viewModel.collectNews(viewLifecycleOwner) { pagingData ->
            newsAdapter.submitData(lifecycle, pagingData)
        }

        newsAdapter.withLoadStateHeaderAndFooter(
            header = loadStateAdapter,
            footer = loadStateAdapter
        )

        newsAdapter.setOnItemClickListener { news ->
            if (news != null) viewModel.pressNewsItem(news)
        }

        newsAdapter.addLoadStateListener { state ->
            viewModel.changedNewsLoadState(state.refresh)
        }

        loadStateAdapter.setOnRetryButtonClickListener {
            newsAdapter.retry()
        }
    }

    override fun initView(savedInstanceState: Bundle?) = with(requireViewBinding()) {
        super.initView(savedInstanceState)

        newsRecycler.adapter = newsAdapter

        recyclerSwipeRefresh.setOnRefreshListener { newsAdapter.refresh() }

        categoryChipGroup.setOnCheckedStateChangeListener { group, _ ->
            viewModel.changedCategory(group.checkedChipButtonTag().convertToCategory())
        }
    }

    override fun onDestroyView() {
        requireViewBinding().newsRecycler.adapter = null
        super.onDestroyView()
    }

    override fun fetchViewModelClass() = NewsViewModel::class.java

    override fun fetchViewModelFactory() = factory
}