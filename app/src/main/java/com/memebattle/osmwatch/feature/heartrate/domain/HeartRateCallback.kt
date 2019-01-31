package com.memebattle.osmwatch.feature.heartrate.domain

interface HeartRateCallback {
    fun onSuccess(result: Int)
    fun onError(error: Int)
}