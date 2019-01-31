package com.memebattle.osmwatch.feature.heartrate.presentation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.osmwatch.R
import com.memebattle.osmwatch.core.domain.BaseCallback
import com.memebattle.osmwatch.feature.heartrate.domain.SetCurrentCallback
import kotlinx.android.synthetic.main.fragment_heart_rate.*


class HeartRateFragment : Fragment() {

    lateinit var viewModel: HeartRateViewModel
    lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(HeartRateViewModel::class.java)
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)
        return inflater.inflate(R.layout.fragment_heart_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getHeartRate()
        setCurrent()
    }

    private fun getHeartRate() {
        viewModel.getHeartRate(object : BaseCallback<Int> {
            override fun onSuccess(result: Int) {
                current.text = result.toString()
            }

            override fun onError(error: Throwable) {
                Log.i("TAG", error.toString())
            }
        })
    }

    fun setCurrent() {
        viewModel.setCurrent(object : SetCurrentCallback {
            override fun onResult() {
                navController.navigate(R.id.action_heartRateFragment_to_osmFragment)
            }

        })
    }

}
