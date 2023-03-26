package com.aold.news_settings_feature_impl.domain.common

import com.aold.core.core.handlers.ErrorHandler
import com.aold.core_db.exceptions.StorageExceptions
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 24.10.2022.
 */

internal interface SettingsErrorHandler : ErrorHandler<SettingsFailures> {

    class Base @Inject constructor() : SettingsErrorHandler {

        override fun handle(throwable: Throwable) = when (throwable) {
            is StorageExceptions -> SettingsFailures.DataBaseException(throwable)
            else -> SettingsFailures.OtherException(throwable)
        }
    }
}