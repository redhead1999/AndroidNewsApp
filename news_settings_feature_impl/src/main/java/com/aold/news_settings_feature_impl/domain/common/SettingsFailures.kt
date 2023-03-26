package com.aold.news_settings_feature_impl.domain.common

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal sealed class SettingsFailures {

    data class DataBaseException(val throwable: Throwable) : SettingsFailures()

    data class OtherException(val throwable: Throwable) : SettingsFailures()
}