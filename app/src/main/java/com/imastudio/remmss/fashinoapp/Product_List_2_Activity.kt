package com.imastudio.remmss.fashinoapp

import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

/**
 * Created by Remmss on 19-09-17.
 */

class Product_List_2_Activity : AppCompatActivity() {

    internal lateinit var tabLayout: TabLayout
    internal lateinit var viewPager: ViewPager
    private var mTypeface: Typeface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list_2)


        viewPager = findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager)

        tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)


        mTypeface = Typeface.createFromAsset(this@Product_List_2_Activity.assets, "fonts/Roboto-Medium.ttf")
        val vg = tabLayout.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                (tabViewChild as? TextView)?.setTypeface(mTypeface, Typeface.NORMAL)
            }
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PopularFragment(), "Popular")
        adapter.addFragment(PopularFragment(), "Low Price")
        adapter.addFragment(PopularFragment(), "High Price")
        adapter.addFragment(PopularFragment(), "Sale")

        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }

}