package com.memebattle.osmwatch.feature.result.presentation

import androidx.lifecycle.ViewModel
import com.memebattle.osmwatch.App
import com.memebattle.osmwatch.core.domain.interactor.RoomCashService
import javax.inject.Inject

class ResultFragmentViewModel : ViewModel(){
    @Inject
    lateinit var cashService: RoomCashService

    init {
        App.component.inject(this)
    }
    fun saveCurrent(point : Float, zone : String){
        cashService.addCurrent(point, zone)
    }
}