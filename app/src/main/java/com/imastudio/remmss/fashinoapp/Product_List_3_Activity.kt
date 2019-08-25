package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

import Adapter.RecycleAdapter_ProductList_3_filter

/**
 * Created by Remmss on 19-09-17.
 */


class Product_List_3_Activity : AppCompatActivity() {

    internal lateinit var tabLayout: TabLayout
    internal lateinit var viewPager: ViewPager


    internal lateinit var filterrecyclerview: RecyclerView

    private var productList_3_filter: RecycleAdapter_ProductList_3_filter? = null
    internal var mContext: Context? = null
    private var mTypeface: Typeface? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list_3)


        filterrecyclerview = findViewById(R.id.filterrecyclerview) as RecyclerView
        viewPager = findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager)

        tabLayout = findViewById(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)


        productList_3_filter = RecycleAdapter_ProductList_3_filter(this@Product_List_3_Activity)
        val mLayoutManager11 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        filterrecyclerview.layoutManager = mLayoutManager11
        filterrecyclerview.itemAnimator = DefaultItemAnimator()
        filterrecyclerview.adapter = productList_3_filter


        mTypeface = Typeface.createFromAsset(this@Product_List_3_Activity.assets, "fonts/Roboto-Medium.ttf")
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
        adapter.addFragment(PopularFragment3(), "Popular")
        adapter.addFragment(PopularFragment3(), "Low Price")
        adapter.addFragment(PopularFragment3(), "High Price")
        adapter.addFragment(PopularFragment3(), "Sale")

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