package com.memebattle.osmwatch.core.di

import com.memebattle.osmwatch.core.di.module.RoomModule
import com.memebattle.osmwatch.core.di.module.SharedPreferencesModule
import com.memebattle.osmwatch.feature.cash_result.CashResultViewModel
import com.memebattle.osmwatch.feature.heartrate.presentation.HeartRateViewModel
import com.memebattle.osmwatch.feature.osm.presentation.OsmFragmentViewModel
import com.memebattle.osmwatch.feature.result.presentation.ResultFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPreferencesModule::class, RoomModule::class])
interface AppComponent {
    fun inject(osmFragmentViewModel: OsmFragmentViewModel)
    fun inject(heartRateViewModel : HeartRateViewModel)
    fun inject(resultFragmentViewModel: ResultFragmentViewModel)
    fun inject(cashResultViewModel: CashResultViewModel)

}