package com.aold.core_db.settings

import com.aold.core_db.exceptions.StorageReadException
import com.aold.core_db.exceptions.StorageUpdateException

/**
 * @author Kirilin Yury on 27.02.2023.
 */

interface SettingsLocalDataSource {

    suspend fun fetchSettings(): SettingsModel

    suspend fun updateSettings(data: SettingsModel)

    class Base(private val dao: SettingsDao) : SettingsLocalDataSource {

        override suspend fun fetchSettings(): SettingsModel {
            return dao.fetchSettings() ?: throw StorageReadException()
        }

        override suspend fun updateSettings(data: SettingsModel) {
            return dao.updateSettings(data).let {
                if (it == 0) throw StorageUpdateException()
            }
        }
    }
}
