package com.example.myreportapp

import android.app.Application
import com.example.myreportapp.utils.ReleaseTree
import com.google.android.datatransport.BuildConfig
import timber.log.Timber

open class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }else{
            Timber.plant(ReleaseTree())
        }
    }
}