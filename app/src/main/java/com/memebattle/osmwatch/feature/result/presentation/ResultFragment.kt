package com.memebattle.osmwatch.feature.result.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.osmwatch.R
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment() {

    lateinit var viewModel : ResultFragmentViewModel
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(ResultFragmentViewModel::class.java)
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val zone = arguments!!["zone"]
        val point = arguments!!["point"]
        viewModel.saveCurrent(point as Float, zone as String)
        zone_display.text = zone.toString()
        point_display.text = point.toString()
        result_parent_layout.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_menuFragment)
        }
    }

}
