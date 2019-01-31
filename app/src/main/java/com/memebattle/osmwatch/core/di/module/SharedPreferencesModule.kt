package com.memebattle.osmwatch.core.di.module

import android.content.Context
import android.content.SharedPreferences
import com.memebattle.osmwatch.core.domain.interactor.SettingsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SharedPreferencesModule(var context: Context) {
    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun settingsService(sharedPreferences: SharedPreferences): SettingsService {
        return SettingsService(sharedPreferences)
    }
}