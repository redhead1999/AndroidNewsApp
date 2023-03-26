package com.aold.runewsapp.di.module

import android.content.Context
import androidx.room.Room
import com.aold.core.di.AppScope
import dagger.Module
import dagger.Provides

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