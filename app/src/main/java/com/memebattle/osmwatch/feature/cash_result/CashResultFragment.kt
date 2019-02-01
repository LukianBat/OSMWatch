package com.memebattle.osmwatch.feature.cash_result


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.memebattle.osmwatch.R
import com.memebattle.osmwatch.core.domain.BaseCallback
import com.memebattle.osmwatch.core.domain.model.CashEntity
import kotlinx.android.synthetic.main.fragment_cash_result.*


class CashResultFragment : Fragment() {

    lateinit var viewModel: CashResultViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(CashResultViewModel::class.java)
        return inflater.inflate(R.layout.fragment_cash_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCash(object : BaseCallback<List<CashEntity>> {
            override fun onSuccess(result: List<CashEntity>) {
                val adapter = ViewPagerResultAdapter(context!!, result)
                pager.adapter = adapter
                pager.currentItem = 0
            }

            override fun onError(error: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

}
