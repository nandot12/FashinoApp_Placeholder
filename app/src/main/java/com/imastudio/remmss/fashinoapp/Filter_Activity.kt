package com.imastudio.remmss.fashinoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ExpandableListView
import android.widget.RadioButton
import android.widget.TextView

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar

import java.util.ArrayList
import java.util.HashMap

import Adapter.ExpandableListAdapter

class Filter_Activity : AppCompatActivity() {




    internal lateinit var listAdapter: ExpandableListAdapter
    internal lateinit var expListView: ExpandableListView
    internal lateinit var listDataHeader: MutableList<String>
    internal var listimage: List<Int>? = null
    internal lateinit var listDataChild: HashMap<String, List<String>>


    private var mBrandsListView: ExpandableListView? = null
    internal var lvExp: ExpandableListView? = null

    private val mBrandAdapter: android.widget.ExpandableListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val lv1 = findViewById(R.id.lvExp) as ExpandableListView



        mBrandsListView = findViewById(R.id.lvExp) as ExpandableListView


        mBrandsListView!!.setAdapter(mBrandAdapter)

        mBrandsListView!!.setOnGroupExpandListener(object : ExpandableListView.OnGroupExpandListener {
            internal var previousGroup = -1

            override fun onGroupExpand(groupPosition: Int) {
                if (previousGroup != -1 && groupPosition != previousGroup) {
                    mBrandsListView!!.collapseGroup(previousGroup)
                }
                previousGroup = groupPosition
            }
        })



        mBrandsListView!!.setOnGroupClickListener { parent, v, groupPosition, id -> false }

        // get the listview
        expListView = findViewById(R.id.lvExp) as ExpandableListView

        // preparing list data
        prepareListData()

        listAdapter = ExpandableListAdapter(this, listDataHeader, listDataChild)

        // setting list adapter
        expListView.setAdapter(listAdapter)
    }


    /*
     * Preparing the list data
     */
    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = HashMap()

        // Adding child data
        listDataHeader.add("Brand")
        listDataHeader.add("Color")
        listDataHeader.add("CPU Type")
        listDataHeader.add("Screen Size")
        listDataHeader.add("Body Weight")
        listDataHeader.add("Operating System")
        listDataHeader.add("RAM")

        // Adding child data
        val top250 = ArrayList<String>()
        top250.add("322 Votes")


        val nowShowing = ArrayList<String>()
        nowShowing.add("322 Votes")


        val comingSoon = ArrayList<String>()
        comingSoon.add("322 Votes")

        val top251 = ArrayList<String>()
        top251.add("322 Votes")

        val top252 = ArrayList<String>()
        top252.add("322 Votes")

        val top253 = ArrayList<String>()
        top253.add("322 Votes")

        val top254 = ArrayList<String>()
        top254.add("322 Votes")


        listDataChild[listDataHeader[0]] = top250 // Header, Child data
        listDataChild[listDataHeader[1]] = nowShowing
        listDataChild[listDataHeader[2]] = comingSoon
        listDataChild[listDataHeader[3]] = top251
        listDataChild[listDataHeader[4]] = top252
        listDataChild[listDataHeader[5]] = top253
        listDataChild[listDataHeader[6]] = top254


        val rangeSeekbar = findViewById(R.id.rangeSeekbar1) as CrystalRangeSeekbar


        val tvMin = findViewById(R.id.textMin1) as TextView
        val tvMax = findViewById(R.id.textMin2) as TextView

        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener { minValue, maxValue ->
            tvMin.text = "$ " + minValue.toString()
            tvMax.text = "$ " + maxValue.toString()
        }

        // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener { minValue, maxValue -> Log.d("CRS=>", minValue.toString() + " : " + maxValue.toString()) }

    }
}
