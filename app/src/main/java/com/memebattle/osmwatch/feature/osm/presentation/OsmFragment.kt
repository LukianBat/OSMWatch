package com.memebattle.osmwatch.feature.osm.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.osmwatch.R
import com.memebattle.osmwatch.feature.osm.domain.SettingsCallback
import kotlinx.android.synthetic.main.fragment_osm.*


class OsmFragment : Fragment() {

    lateinit var viewModel: OsmFragmentViewModel
    private lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)
        viewModel = ViewModelProviders.of(this).get(OsmFragmentViewModel::class.java)
        return inflater.inflate(R.layout.fragment_osm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heart_rate_sit.setOnClickListener {
            navController.navigate(R.id.action_osmFragment_to_heartRateFragment)
        }
        heart_rate_stand.setOnClickListener {
            navController.navigate(R.id.action_osmFragment_to_heartRateFragment)
        }
        displayCurrents()
    }

    fun displayCurrents() {
        viewModel.getSettings(object : SettingsCallback {
            override fun onCurrentSit(result: Int) {
                heart_rate_sit_image.visibility = View.GONE
                heart_rate_sit_text.text = result.toString()
                text_append_sit.visibility = View.VISIBLE
                heart_rate_sit.isClickable = false
            }

            override fun onCurrentStand(result: Int) {
                heart_rate_stand_image.visibility = View.GONE
                heart_rate_stand_text.text = result.toString()
                text_append_stand.visibility = View.VISIBLE
                heart_rate_stand.isClickable = false
                heart_rate_sit.isClickable = false
                viewModel.cleanSettings()
                parent_layout.isClickable = true
                parent_layout.setOnClickListener {
                    var bundle = Bundle()
                    var point = viewModel.getOsmPoints(heart_rate_sit_text.text.toString().toInt(), heart_rate_stand_text.text.toString().toInt())
                    point = Math.round(point*100)/100.toFloat()
                    bundle.putFloat("point", point)
                    bundle.putString("zone", viewModel.getOsmZone(point))
                    navController.navigate(R.id.action_osmFragment_to_resultFragment, bundle)
                }
            }

        })
    }

}
