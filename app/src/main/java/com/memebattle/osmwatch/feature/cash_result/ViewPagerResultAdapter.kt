package com.memebattle.osmwatch.feature.cash_result

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewpager.widget.PagerAdapter
import com.memebattle.osmwatch.core.domain.model.CashEntity
import android.view.LayoutInflater
import androidx.viewpager.widget.ViewPager
import com.memebattle.osmwatch.R
import kotlinx.android.synthetic.main.pager_item.view.*
import android.widget.LinearLayout




class ViewPagerResultAdapter(val context : Context, val listCash : List<CashEntity>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as FrameLayout
    }

    override fun getCount(): Int {
        return listCash.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.pager_item, container,
                false)
        itemView.zone_display_item.text = listCash[position].zone
        itemView.point_display_item.text = listCash[position].point.toString()
        (container as ViewPager).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as FrameLayout)
    }
}