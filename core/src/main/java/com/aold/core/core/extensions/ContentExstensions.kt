package com.aold.core.core.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * @author Kirilin Yury on 26.02.2023.
 */
fun Context.openUrl(url: String) = startActivity(
    Intent(Intent.ACTION_VIEW, Uri.parse(url))
)