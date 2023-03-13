package com.aold.news_feature_impl.presentation.ui.news.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.aold.news_feature_impl.presentation.models.NewsUi
import javax.inject.Inject

/**
 * @author Kirilin Yury on 14.03.2023.
 */

internal class NewsAdapter @Inject constructor() : PagingDataAdapter<NewsUi, NewsViewHolder>(
    diffCallback = NewsDiffUtil()
) {

    private var listener: ((NewsUi?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position), requireClickListener())
    }

    fun setOnItemClickListener(listener: (NewsUi?) -> Unit) {
        this.listener = listener
    }

    private fun requireClickListener() = checkNotNull(listener) {
        "OnItemClickListener is not initializing"
    }
}