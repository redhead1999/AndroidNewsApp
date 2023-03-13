package com.aold.news_feature_impl.presentation.ui.news.adapters

import androidx.recyclerview.widget.DiffUtil
import com.aold.news_feature_impl.presentation.models.NewsUi

/**
 * @author Kirilin Yury on 14.03.2023.
 */

internal class NewsDiffUtil : DiffUtil.ItemCallback<NewsUi>() {
    override fun areItemsTheSame(oldItem: NewsUi, newItem: NewsUi): Boolean {
        return oldItem.title == oldItem.title
    }

    override fun areContentsTheSame(oldItem: NewsUi, newItem: NewsUi): Boolean {
        return oldItem == newItem
    }
}