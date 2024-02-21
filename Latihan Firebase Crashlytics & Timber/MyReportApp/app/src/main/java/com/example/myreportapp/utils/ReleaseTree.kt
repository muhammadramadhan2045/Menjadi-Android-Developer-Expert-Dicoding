package com.example.myreportapp.utils

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority== Log.ERROR || priority== Log.WARN){
            if(t==null){
                //send crash report to firebase
                FirebaseCrashlytics.getInstance().log(message)
            }else{
                FirebaseCrashlytics.getInstance().recordException(t)
            }
        }
    }
}