package com.aold.runewsapp.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.aold.core.di.AppScope
import com.aold.core_db.details.NewsDetailsLocalDataSource
import com.aold.core_db.settings.SettingsDao
import com.aold.core_db.settings.SettingsDataBase
import com.aold.core_db.settings.SettingsLocalDataSource

/**
 * @author Kirilin Yury on 26.02.2023.
 */

@Module
class CoreDataModule {

    @Provides
    @AppScope
    fun provideSettingsDatabase(
        context: Context
    ): SettingsDatabase{
        return Room
            .database
    }
}