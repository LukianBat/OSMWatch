package com.memebattle.osmwatch.core.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CashEntity(var point : Float, var zone : String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}