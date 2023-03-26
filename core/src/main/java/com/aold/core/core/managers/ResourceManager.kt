package com.aold.core.core.managers

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.02.2023.
 */

interface ResourceManager {

    fun fetchDrawable(@DrawableRes id: Int): Drawable

    fun fetchString(@StringRes id: Int): String

    class Base @Inject constructor(private val context: Context) : ResourceManager {

        override fun fetchDrawable(id: Int) = checkNotNull(
            AppCompatResources.getDrawable(context, id)
        ) { "Drawable resource(id = $id) is not found!" }

        override fun fetchString(id: Int) = context.getString(id)
    }
}