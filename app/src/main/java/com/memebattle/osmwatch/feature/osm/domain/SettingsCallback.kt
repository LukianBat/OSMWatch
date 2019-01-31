package com.memebattle.osmwatch.feature.osm.domain


interface SettingsCallback {
    fun onCurrentSit(result: Int)
    fun onCurrentStand(result: Int)
}