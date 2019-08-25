package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import Adapter.RecycleAdapter_ProductListGrid3
import Adapter.RecycleAdapter_Similar_product
import Adapter.RecycleviewAdapter_Product_2_Size
import Adapter.RecycleviewAdapter_home_3_Browse_Category
import App_help.Circle_indicator
import ModalClass.BeanClassForProductList
import ModalClass.BrowseByCategoryModalClass
import ModalClass.Home1_TredingModalClass
import ModalClass.ModalClassSizeList
import me.relex.circleindicator.CircleIndicator

class ProductDetail_2_Activity : AppCompatActivity() {

    internal lateinit var size_recycleview: RecyclerView
    internal lateinit var product_2_size: RecycleviewAdapter_Product_2_Size

    private var modalClassSizeLists: ArrayList<ModalClassSizeList>? = null


    internal var mContext: Context = this@ProductDetail_2_Activity
    internal lateinit var viewPager: ViewPager
    private var layouts1: IntArray? = null
    internal lateinit var myViewPagerAdapter: MyViewPagerAdapter
    internal var arry: Array<String>? = null

    private var beanClassForProductLists: ArrayList<BeanClassForProductList>? = null

    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecycleAdapter_Similar_product? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail_2_)


        size_recycleview = findViewById(R.id.size_recycleview) as RecyclerView

        viewPager = findViewById(R.id.viewpager) as ViewPager
        val indicator = findViewById(R.id.indicator) as CircleIndicator


        modalClassSizeLists = ArrayList()

        modalClassSizeLists!!.add(ModalClassSizeList("26"))
        modalClassSizeLists!!.add(ModalClassSizeList("28"))
        modalClassSizeLists!!.add(ModalClassSizeList("30"))
        modalClassSizeLists!!.add(ModalClassSizeList("32"))
        modalClassSizeLists!!.add(ModalClassSizeList("36"))


        product_2_size = RecycleviewAdapter_Product_2_Size(this@ProductDetail_2_Activity, modalClassSizeLists!!)
        val mLayoutManager11 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        size_recycleview.layoutManager = mLayoutManager11
        size_recycleview.itemAnimator = DefaultItemAnimator()
        size_recycleview.adapter = product_2_size




        recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        beanClassForProductLists = ArrayList()


        beanClassForProductLists = ArrayList()

        beanClassForProductLists!!.add(BeanClassForProductList("Black Shorts", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Black Shorts", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Black Shorts", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Black Shorts", R.drawable.white))


        mAdapter = RecycleAdapter_Similar_product(this@ProductDetail_2_Activity, beanClassForProductLists!!)

        val mLayoutManager = GridLayoutManager(this@ProductDetail_2_Activity, 2)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter



        layouts1 = intArrayOf(

                R.layout.sliding_product_detail_2, R.layout.sliding_product_detail_2, R.layout.sliding_product_detail_2, R.layout.sliding_product_detail_2)


        myViewPagerAdapter = MyViewPagerAdapter()
        viewPager.adapter = myViewPagerAdapter
        viewPager.currentItem = 0
        //  viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        indicator.setViewPager(viewPager)


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

            val view = layoutInflater!!.inflate(layouts1!![position], container, false)
            container.addView(view)

            return view
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
