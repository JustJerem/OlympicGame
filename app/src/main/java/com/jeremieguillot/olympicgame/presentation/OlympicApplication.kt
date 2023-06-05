package com.jeremieguillot.olympicgame.presentation

import android.app.Application
import android.util.Log
import com.ramcosta.composedestinations.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class OlympicApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant(CrashReportingTree())
        }
    }

    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (t != null && (priority == Log.WARN || priority == Log.ERROR) && !BuildConfig.DEBUG) {
               //here can be used a Firebase Crashlytics instance to record and report bugs
            }
        }
    }
}