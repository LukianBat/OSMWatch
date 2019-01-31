package com.memebattle.osmwatch.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.memebattle.osmwatch.core.domain.model.CashEntity
import io.reactivex.Flowable



@Dao
interface CashDao {

    @Insert
    fun addCurrent(current: CashEntity)

    @Query("SELECT * FROM cashentity")
    fun getAll(): Flowable<List<CashEntity>>


}