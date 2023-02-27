package com.aold.core_db.settings

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

@Database(entities = [SettingsModel::class], version = 1)
abstract class SettingsDataBase : RoomDatabase() {

    abstract fun fetchSettingsDao(): SettingsDao

    companion object {
        const val DATABASE_NAME = "ru_news_settings.db"
        const val PREPOPULATE_DATABASE_NAME = "database/run_news_settings_prepopulate.db"
    }
}