package com.example.messangerapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.github.venom.Venom
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MessengerAppApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        Venom.createInstance(this).apply {
            initialize()
            start()
        }
    }

    override fun getWorkManagerConfiguration() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}