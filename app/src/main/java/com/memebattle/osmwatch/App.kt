package com.memebattle.osmwatch

import android.app.Application
import com.memebattle.osmwatch.core.di.AppComponent
import com.memebattle.osmwatch.core.di.DaggerAppComponent
import com.memebattle.osmwatch.core.di.module.RoomModule
import com.memebattle.osmwatch.core.di.module.SharedPreferencesModule

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder()
                .sharedPreferencesModule(SharedPreferencesModule(applicationContext))
                .roomModule(RoomModule(applicationContext))
                .build()
    }
}