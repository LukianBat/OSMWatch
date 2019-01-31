package com.memebattle.osmwatch.feature.heartrate.domain

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.*
import android.util.Log
import com.memebattle.osmwatch.App


class HeartRateService(context: Context, var callback: HeartRateCallback) : SensorEventListener {
    lateinit var heartRateSensor: Sensor
    lateinit var sensorManager: SensorManager

    init {
        sensorManager = App.instance.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE)
        sensorManager.registerListener(this, heartRateSensor,
                SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.i("TAG", "accuracy = $accuracy")
        if (accuracy == SENSOR_STATUS_NO_CONTACT || accuracy == SENSOR_STATUS_UNRELIABLE) {
            callback.onError(-2)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_HEART_RATE && event.accuracy == SENSOR_STATUS_ACCURACY_HIGH && event.values[0] > 0) {
            callback.onSuccess(event.values[0].toInt())
            Log.i("TAG", "accuracy = " + event.accuracy)
        } else {
            callback.onError(-2)
        }
    }

    fun stopService() {
        sensorManager.unregisterListener(this)
    }
}