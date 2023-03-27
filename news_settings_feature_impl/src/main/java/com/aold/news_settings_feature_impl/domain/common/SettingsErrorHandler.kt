package com.aold.news_settings_feature_impl.domain.common

import com.aold.core.core.handlers.ErrorHandler
import com.aold.core_db.exceptions.StorageExceptions
import javax.inject.Inject

/**
 * @author Kirilin Yury on 27.03.2023.
 */

internal interface SettingsErrorHandler : ErrorHandler<SettingsFailures> {

    class Base @Inject constructor() : SettingsErrorHandler {

        override fun handle(throwable: Throwable) = when (throwable) {
            is StorageExceptions -> SettingsFailures.DataBaseException(throwable)
            else -> SettingsFailures.OtherException(throwable)
        }
    }
}