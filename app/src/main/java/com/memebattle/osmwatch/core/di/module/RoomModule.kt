package com.memebattle.osmwatch.core.di.module

import android.content.Context
import androidx.room.Room
import com.memebattle.osmwatch.core.data.AppDatabase
import com.memebattle.osmwatch.core.domain.interactor.RoomCashService
import com.memebattle.osmwatch.core.data.CashDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule(val context: Context) {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
    }

    @Provides
    @Singleton
    fun provideCashDao(appDatabase: AppDatabase): CashDao {
        return appDatabase.cashDao()
    }

    @Provides
    @Singleton
    fun roomCashService(dao: CashDao): RoomCashService {
        return RoomCashService(dao)
    }
}