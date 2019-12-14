package com.eduardo.calculadoraflex

import android.app.Application
import com.facebook.stetho.Stetho

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Bloqueia alteração do user_preference somente para modo DEBUG do app
        if (BuildConfig.DEBUG)
        //

            Stetho.initializeWithDefaults(this)
    }
}