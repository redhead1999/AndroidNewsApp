package com.aold.runewsapp.di.module

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides
import com.aold.runewsapp.core.di.AppScope
import com.aold.runewsapp.core.navigations.BottomNavRouter
import com.aold.runewsapp.core.navigations.GlobalRouter
import com.aold.runewsapp.globalnews.di.annotation.GlobalCiceroneHolder
import com.aold.runewsapp.globalnews.di.annotation.NavCiceroneHolder

/**
 * @author Kirilin Yury on 26.02.2023
 */

@Module
class NavigationModule {

    @[Provides AppScope]
    fun provideGlobalCicerone() = Cicerone.create(GlobalRouter())

    @[Provides AppScope GlobalCiceroneHolder]
    fun provideGlobalNavigatorHolder(cicerone: Cicerone<GlobalRouter>) = cicerone.getNavigatorHolder()

    @[Provides AppScope]
    fun provideGlobalRouter(cicerone: Cicerone<GlobalRouter>) = cicerone.router

    @[Provides AppScope]
    fun provideNavCicerone() = Cicerone.create(BottomNavRouter())

    @[Provides AppScope NavCiceroneHolder]
    fun provideNavNavigatorHolder(cicerone: Cicerone<BottomNavRouter>) = cicerone.getNavigatorHolder()

    @[Provides AppScope]
    fun provideNavRouter(cicerone: Cicerone<BottomNavRouter>) = cicerone.router
}