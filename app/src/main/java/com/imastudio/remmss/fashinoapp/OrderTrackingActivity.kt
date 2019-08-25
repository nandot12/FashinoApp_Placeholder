package com.imastudio.remmss.fashinoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import Adapter.RecycleAdapter_TrackOrder
import com.imastudio.remmss.fashinoapp.home.produk.adapter.KategoriAdapter
import ModalClass.Home1_TredingModalClass
import ModalClass.TrackModalClass

/**
 * Created by Remmss on 27-10-17.
 */

class OrderTrackingActivity : AppCompatActivity() {

    internal lateinit var recycle: RecyclerView
    internal lateinit var recycle1: RecyclerView
    private var trackModalClasses: ArrayList<TrackModalClass>? = null
    private var adapter_trackOrder: RecycleAdapter_TrackOrder? = null

    private var adapter_home_2_products: KategoriAdapter? = null
    private var home1_tredingModalClassArrayList: ArrayList<Home1_TredingModalClass>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_tracking)

        recycle = findViewById(R.id.recycle) as RecyclerView
        recycle1 = findViewById(R.id.recycle1) as RecyclerView


        trackModalClasses = ArrayList()


        trackModalClasses?.add(TrackModalClass("Order Placed"))
        trackModalClasses?.add(TrackModalClass("Order Confirmed"))
        trackModalClasses!!.add(TrackModalClass("Order Shipped"))
        trackModalClasses!!.add(TrackModalClass("Out Of Delivery"))
        trackModalClasses!!.add(TrackModalClass("Delivered"))


        adapter_trackOrder = RecycleAdapter_TrackOrder(this@OrderTrackingActivity, trackModalClasses!!)
        val mLayoutManager = LinearLayoutManager(this@OrderTrackingActivity)
        recycle.layoutManager = mLayoutManager
        recycle.adapter = adapter_trackOrder


        home1_tredingModalClassArrayList = ArrayList()

        home1_tredingModalClassArrayList!!.add(Home1_TredingModalClass("Cosmos", 389, R.drawable.cosmos))
        home1_tredingModalClassArrayList!!.add(Home1_TredingModalClass("HTC Hoof ", 719, R.drawable.htc))
        home1_tredingModalClassArrayList!!.add(Home1_TredingModalClass("Cosmos ", 719, R.drawable.cosmos))
        home1_tredingModalClassArrayList!!.add(Home1_TredingModalClass("HTC Hoof", 719, R.drawable.htc))
        home1_tredingModalClassArrayList!!.add(Home1_TredingModalClass("Cosmos ", 719, R.drawable.cosmos))
        home1_tredingModalClassArrayList!!.add(Home1_TredingModalClass("HTC Hoof ", 719, R.drawable.htc))

      //  adapter_home_2_products = KategoriAdapter(this@OrderTrackingActivity, home1_tredingModalClassArrayList!!)
        //val mLayoutManager11 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //recycle1.layoutManager = mLayoutManager11
        //recycle1.itemAnimator = DefaultItemAnimator()
       // recycle1.adapter = adapter_home_2_products


    }
}
