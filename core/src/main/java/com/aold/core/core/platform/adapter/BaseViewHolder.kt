package com.aold.core.core.platform.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author Kirilin Yury on 26.02.2023.
 */

abstract class BaseViewHolder<I>(
    viewBindng: ViewBinding
) : RecyclerView.ViewHolder(viewBindng.root) {

    open fun bind(data: I) {}

    open fun bind(data: I, payLoad: List<Any>) {}
}