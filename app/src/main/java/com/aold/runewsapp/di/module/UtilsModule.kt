package com.aold.runewsapp.di.module

import dagger.Binds
import dagger.Module
import com.aold.runewsapp.core.managers.CoroutineManager
import com.aold.runewsapp.navigation.AppNavigationManager

/**
 * @author Kirilin Yury on 26.02.2023.
 */

@Module
interface UtilsModule {

    @Binds
    fun provideAppNavigationManager(manager: AppNavigationManager.Base): AppNavigationManager

    @Binds
    fun provideCoroutineManger(manager: CoroutineManager.Base): CoroutineManager
}