package com.aold.news_feature_impl.presentation.ui.news.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aold.core.core.extensions.loadImage
import com.aold.core.core.platform.adapter.BaseViewHolder
import com.aold.news_feature_impl.R
import com.aold.news_feature_impl.databinding.NewsItemBinding
import com.aold.news_feature_impl.presentation.models.NewsUi

/**
 * @author Stanislav Aleshin on 15.10.2022.
 */
internal class NewsViewHolder(
    private val viewBinding: NewsItemBinding
) : BaseViewHolder<NewsUi>(viewBinding) {

    private val context get() = viewBinding.root.context

    fun bind(data: NewsUi?, listener: (NewsUi?) -> Unit) = with(viewBinding) {
        val placeholderTitle = context.getText(R.string.no_information_available_title)

        if (data != null) newsImage.loadImage(data.imageUrl, R.drawable.missing_photo)

        contentTitle.text = data?.title ?: placeholderTitle
        publishedDateTitle.text = data?.publishedAt ?: placeholderTitle
        sourceTitle.text = data?.source ?: placeholderTitle

        root.setOnClickListener { listener.invoke(data) }
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewBinding = NewsItemBinding.inflate(layoutInflater, parent, false)

            return NewsViewHolder(viewBinding)
        }
    }
}