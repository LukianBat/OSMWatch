package com.memebattle.osmwatch.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memebattle.osmwatch.core.domain.model.CashEntity

@Database(entities = [CashEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cashDao(): CashDao
}