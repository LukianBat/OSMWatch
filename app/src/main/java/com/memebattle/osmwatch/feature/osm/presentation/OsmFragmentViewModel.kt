package com.memebattle.osmwatch.feature.osm.presentation

import androidx.lifecycle.ViewModel
import com.memebattle.osmwatch.App
import com.memebattle.osmwatch.core.domain.interactor.SettingsService
import com.memebattle.osmwatch.feature.osm.domain.SettingsCallback
import javax.inject.Inject

class OsmFragmentViewModel : ViewModel() {
    @Inject
    lateinit var settingsService: SettingsService

    init {
        App.component.inject(this)
    }

    fun getSettings(callback: SettingsCallback) {
        if (settingsService.isCurrentSitNotEmpty()) {
            callback.onCurrentSit(settingsService.getCurrentSit())
        }
        if (settingsService.isCurrentStandNotEmpty()) {
            callback.onCurrentStand(settingsService.getCurrentStand())
        }
    }
    fun cleanSettings(){
        settingsService.cleanSettings()
    }
    fun getOsmZone(point : Float): String{
        var n = ""
        if (point >= 7.5)
            n = "I"
        if (point >= 5 && point < 7.5)
            n = "II"
        if (point >= 2.5 && point < 5)
            n = "III"
        if (point < 2.5)
            n = "IV"
        return n
    }
    fun getOsmPoints(sitCurrent : Int, standCurrent : Int): Float{
        return (14.5 - 0.5 * ( (sitCurrent) - 40) / 3.5 - ( (standCurrent - sitCurrent)) / 2.23 * 0.5).toFloat()
    }
}