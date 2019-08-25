package com.imastudio.remmss.fashinoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import Adapter.RecycleAdapter_Color
import Adapter.RecycleAdapter_Productdetail_ImageAdapter
import Adapter.RecycleAdapter_Storage
import Adapter.RecycleviewAdapter_Products_detail
import ModalClass.BeanClassForProductList

class ProductDetailActivity2 : AppCompatActivity() {

    internal lateinit var image_recycleview: RecyclerView
    internal var imageRecyclerview: RecyclerView? = null
    internal lateinit var colorrecyclerview: RecyclerView
    internal lateinit var storagerecyclerview: RecyclerView
    internal var similarproductrecyclerview: RecyclerView? = null
    internal lateinit var product_detail_recyclevew: RecyclerView
    internal var list: MutableList<String> = ArrayList()
    internal lateinit var adapter_products_detail: RecycleviewAdapter_Products_detail

    private var beanClassForProductLists: ArrayList<BeanClassForProductList>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        image_recycleview = findViewById(R.id.image_recycleview) as RecyclerView
        colorrecyclerview = findViewById(R.id.colorrecyclerview) as RecyclerView
        storagerecyclerview = findViewById(R.id.storagerecyclerview) as RecyclerView
        product_detail_recyclevew = findViewById(R.id.product_detail_recyclevew) as RecyclerView

        list.add("1")
        list.add("1")
        list.add("1")


        val linearLayoutManager = LinearLayoutManager(this@ProductDetailActivity2, LinearLayoutManager.VERTICAL, false)
        val imagesProductdetailAdapter = RecycleAdapter_Productdetail_ImageAdapter(this@ProductDetailActivity2)
        image_recycleview.layoutManager = linearLayoutManager
        image_recycleview.adapter = imagesProductdetailAdapter


        val linearLayoutManager1 = LinearLayoutManager(this@ProductDetailActivity2, LinearLayoutManager.HORIZONTAL, false)
        val linearLayoutManager2 = LinearLayoutManager(this@ProductDetailActivity2, LinearLayoutManager.HORIZONTAL, false)

        val recycleAdapter_color = RecycleAdapter_Color(list, this@ProductDetailActivity2)
        colorrecyclerview.layoutManager = linearLayoutManager1
        colorrecyclerview.adapter = recycleAdapter_color

        val recycleAdapter_storage = RecycleAdapter_Storage(list, this@ProductDetailActivity2)
        storagerecyclerview.layoutManager = linearLayoutManager2
        storagerecyclerview.adapter = recycleAdapter_storage

        beanClassForProductLists = ArrayList()

        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 7", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 4", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 5s", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 4s", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6", R.drawable.white))


        adapter_products_detail = RecycleviewAdapter_Products_detail(this@ProductDetailActivity2, beanClassForProductLists!!)
        val mLayoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        product_detail_recyclevew.layoutManager = mLayoutManager2
        product_detail_recyclevew.itemAnimator = DefaultItemAnimator()
        product_detail_recyclevew.adapter = adapter_products_detail


    }
}
