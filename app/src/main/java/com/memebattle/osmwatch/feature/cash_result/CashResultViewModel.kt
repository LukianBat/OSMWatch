package com.memebattle.osmwatch.feature.cash_result

import androidx.lifecycle.ViewModel
import com.memebattle.osmwatch.App
import com.memebattle.osmwatch.core.domain.BaseCallback
import com.memebattle.osmwatch.core.domain.interactor.RoomCashService
import com.memebattle.osmwatch.core.domain.interactor.SettingsService
import com.memebattle.osmwatch.core.domain.model.CashEntity
import javax.inject.Inject

class CashResultViewModel : ViewModel(){
    @Inject
    lateinit var roomCashService: RoomCashService

    init {
        App.component.inject(this)
    }
    fun getCash(baseCallback: BaseCallback<List<CashEntity>>){
        roomCashService.getAllCurrents(object : BaseCallback<List<CashEntity>>{
            override fun onSuccess(result: List<CashEntity>) {
                baseCallback.onSuccess(result)
            }

            override fun onError(error: Throwable) {
                baseCallback.onError(error)
            }

        })
    }
}