package com.memebattle.osmwatch.feature.heartrate.presentation

import androidx.lifecycle.ViewModel
import com.memebattle.osmwatch.App
import com.memebattle.osmwatch.core.domain.BaseCallback
import com.memebattle.osmwatch.feature.heartrate.domain.HeartRateCallback
import com.memebattle.osmwatch.feature.heartrate.domain.HeartRateService
import com.memebattle.osmwatch.core.domain.interactor.SettingsService
import com.memebattle.osmwatch.feature.heartrate.domain.SetCurrentCallback
import java.util.*
import javax.inject.Inject


class HeartRateViewModel : ViewModel() {
    private var lastCurrent = 0
    private lateinit var heartRateService: HeartRateService
    @Inject
    lateinit var settingsService: SettingsService

    init {
        App.component.inject(this)
    }

    fun getHeartRate(callback: BaseCallback<Int>) {
        heartRateService = HeartRateService(App.instance.applicationContext, object : HeartRateCallback {
            override fun onSuccess(result: Int) {
                callback.onSuccess(result)
                lastCurrent = result
            }

            override fun onError(error: Int) {
                callback.onSuccess(lastCurrent)
            }

        })
    }

    fun setCurrent(callback: SetCurrentCallback) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (lastCurrent != 0) {
                    heartRateService.stopService()
                    settingsService.setCurrent(lastCurrent)
                    callback.onResult()
                } else {
                    setCurrent(callback)
                }
            }
        }, 10000)
    }
}