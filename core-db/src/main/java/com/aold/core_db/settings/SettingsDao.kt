package com.aold.core_db.settings

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

@Dao
interface SettingsDao {

    @Query("SELECT * FROM settings WHERE id = 1 LIMIT 1")
    fun fetchSettings(): SettingsModel?

    @Update
    fun updateSettings(settingsModel: SettingsModel): Int
}