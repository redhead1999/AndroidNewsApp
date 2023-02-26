package com.aold.core.core.managers

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

interface DateManager {

    fun parseIsoInstant(date: String): String

    class Base : DateManager {

        override fun parseIsoInstant(date: String): String {
            val currentDate = SimpleDateFormat(ISO_INSTANT, Locale.getDefault()).parse(date) ?: ""
            val correctDateFormat = SimpleDateFormat.getDateTimeInstance() // ("EEE, d MMM yyyy HH:mm:ss", Locale.getDefault())

            return correctDateFormat.format(currentDate)
        }

        companion object {
            const val ISO_INSTANT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        }
    }
}