package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import Adapter.RecycleviewAdapter_Category_list
import Adapter.RecycleviewAdapter_Color_list
import Adapter.RecycleviewAdapter_Feature_Sports
import Adapter.RecycleviewAdapter_Treding
import App_help.Circle_indicator
import ModalClass.CategoryModalClass
import ModalClass.ColorModalClass
import ModalClass.TredingModalClass
import me.relex.circleindicator.CircleIndicator

class MainActivity : AppCompatActivity() {

    internal lateinit var category_recycleview: RecyclerView
    internal lateinit var treding_recycleview: RecyclerView
    internal lateinit var color_recycleview: RecyclerView
    internal lateinit var sports_recycleview: RecyclerView

    private var adapterCategoryList: RecycleviewAdapter_Category_list? = null
    private var adapterTreding: RecycleviewAdapter_Treding? = null
    private var adapter_color_list: RecycleviewAdapter_Color_list? = null
    private var adapter_feature_sports: RecycleviewAdapter_Feature_Sports? = null


    private var categoryModalClassArrayList: ArrayList<CategoryModalClass>? = null
    private var tredingModalClassArrayList: ArrayList<TredingModalClass>? = null
    private var colorModalClassArrayList: ArrayList<ColorModalClass>? = null

    internal var mContext: Context = this@MainActivity
    internal lateinit var viewPager: ViewPager
    private var layouts1: IntArray? = null
    internal lateinit var myViewPagerAdapter: MainActivity.MyViewPagerAdapter
    internal lateinit var arry: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        category_recycleview = findViewById(R.id.category_recycleview) as RecyclerView
        treding_recycleview = findViewById(R.id.treding_recycleview) as RecyclerView
        color_recycleview = findViewById(R.id.color_recycleview) as RecyclerView
        sports_recycleview = findViewById(R.id.sports_recycleview) as RecyclerView

        viewPager = findViewById(R.id.viewpager) as ViewPager
        val indicator = findViewById(R.id.indicator) as CircleIndicator



        categoryModalClassArrayList = ArrayList()

        categoryModalClassArrayList?.add(CategoryModalClass("Kids Wear"))
        categoryModalClassArrayList?.add(CategoryModalClass("Mens Wear"))
        categoryModalClassArrayList?.add(CategoryModalClass("Womens Wear"))
        categoryModalClassArrayList?.add(CategoryModalClass("Kids Wear"))
        categoryModalClassArrayList?.add(CategoryModalClass("Mens Wear"))
        categoryModalClassArrayList?.add(CategoryModalClass("Womens Wear"))



        adapterCategoryList = RecycleviewAdapter_Category_list(mContext, categoryModalClassArrayList!!)
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        category_recycleview.layoutManager = mLayoutManager
        category_recycleview.itemAnimator = DefaultItemAnimator()
        category_recycleview.adapter = adapterCategoryList



        tredingModalClassArrayList = ArrayList()

        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 89, 365))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "White Shoes", 120, 489))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 76, 395))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "White Shoes", 70, 205))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 90, 455))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "White Shoes", 89, 365))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 89, 365))

        adapterTreding = RecycleviewAdapter_Treding(mContext, tredingModalClassArrayList!!)
        val mLayoutManager11 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        treding_recycleview.layoutManager = mLayoutManager11
        treding_recycleview.itemAnimator = DefaultItemAnimator()
        treding_recycleview.adapter = adapterTreding



        colorModalClassArrayList = ArrayList()

        colorModalClassArrayList?.add(ColorModalClass(R.drawable.solid_circle2))
        colorModalClassArrayList?.add(ColorModalClass(R.drawable.solid_circle1))
        colorModalClassArrayList?.add(ColorModalClass(R.drawable.solid_circle))

        adapter_color_list = RecycleviewAdapter_Color_list(mContext, colorModalClassArrayList!!)
        color_recycleview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        color_recycleview.adapter = adapter_color_list


        tredingModalClassArrayList = ArrayList()

        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 89, 365))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "White Shoes", 120, 489))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 76, 395))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "White Shoes", 70, 205))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 90, 455))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "White Shoes", 89, 365))
        tredingModalClassArrayList?.add(TredingModalClass(R.drawable.white, "Febric Black Doss", 89, 365))

        adapter_feature_sports = RecycleviewAdapter_Feature_Sports(mContext, tredingModalClassArrayList!!)
        val mLayoutManager12 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        sports_recycleview.layoutManager = mLayoutManager12
        sports_recycleview.itemAnimator = DefaultItemAnimator()
        sports_recycleview.adapter = adapter_feature_sports




        layouts1 = intArrayOf(

                R.layout.activity_discount_sliding1, R.layout.activity_discount_sliding2, R.layout.activity_discount_sliding3, R.layout.activity_discount_sliding4)


        arry = resources.getStringArray(R.array.steps)
        myViewPagerAdapter = MainActivity().MyViewPagerAdapter()
        viewPager.adapter = myViewPagerAdapter
        viewPager.currentItem = 0
        //  viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        indicator.setViewPager(viewPager)

        val circle_indicator = Circle_indicator()
        circle_indicator.autoSlider(viewPager, arry, mContext)


        val viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                // addBottomDots(position);
                //circle_indicator.setText(arry[position]);
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(arg0: Int) {

            }
        }


    }

    inner class MyViewPagerAdapter : PagerAdapter() {

        private var layoutInflater: LayoutInflater? = null

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = layoutInflater?.inflate(layouts1!![position], container, false)
            container.addView(view)

            return view!!
        }


        override fun getCount(): Int {
            return layouts1!!.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }


}
