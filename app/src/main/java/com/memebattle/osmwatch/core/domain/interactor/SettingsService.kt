package com.memebattle.osmwatch.core.domain.interactor

import android.content.SharedPreferences
import java.lang.Error

class SettingsService(private val sharedPreferences: SharedPreferences) {

    val currentSit = "currentSit"
    val currentStand = "currentStand"
    val ERROR = -2

    private fun setCurrentSit(current: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(currentSit, current)
        editor.apply()
    }
    fun getCurrentSit(): Int {
        return sharedPreferences.getInt(currentSit, ERROR)
    }
    private fun setCurrentStand(current: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(currentStand, current)
        editor.apply()
    }
    fun getCurrentStand(): Int {
        return sharedPreferences.getInt(currentStand, ERROR)

    }
    fun setCurrent(current: Int){
        if (getCurrentSit()==ERROR && getCurrentStand() == ERROR){
            setCurrentSit(current)
        }else if(getCurrentSit()!=ERROR && getCurrentStand()==ERROR){
            setCurrentStand(current)
        }
    }
    fun isCurrentSitNotEmpty():Boolean{
        return getCurrentSit() != ERROR
    }
    fun isCurrentStandNotEmpty():Boolean{
        return getCurrentStand() != ERROR
    }
    fun cleanSettings(){
        val editor = sharedPreferences.edit()
        editor.putInt(currentSit, ERROR)
        editor.putInt(currentStand, ERROR)
        editor.apply()
    }
}