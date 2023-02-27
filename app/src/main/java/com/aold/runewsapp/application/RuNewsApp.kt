package com.aold.runewsapp.application

import android.app.Application
import android.content.Context
import com.aold.runewsapp.di.component.AppComponent
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */
class RuNewsApp : Application(), FetchAppComponent {

    private var appComponent: AppComponent? = null
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(applicationContext)
        mFirebaseAnalytics = Firebase.analytics
    }


    override fun fetchAppComponent(): AppComponent {
        return checkNotNull(appComponent) { "AppComponent is not initializing" }
    }

    fun Context.getApp(): RuNewsApp {
        return applicationContext as RuNewsApp
    }
}