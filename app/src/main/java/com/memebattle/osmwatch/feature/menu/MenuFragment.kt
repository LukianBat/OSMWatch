package com.memebattle.osmwatch.feature.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.osmwatch.R
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment() {

    private lateinit var navController : NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)
        return inflater.inflate(R.layout.fragment_menu, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        osm.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_osmFragment)
        }
        results.setOnClickListener {
            navController.navigate(R.id.action_menuFragment_to_cashResultFragment)
        }
    }

}
