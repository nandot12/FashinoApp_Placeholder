package com.imastudio.remmss.fashinoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import Adapter.RecycleAdapter_GridList_3_filter
import Adapter.RecycleAdapter_ProductListGrid
import Adapter.RecycleAdapter_ProductListGrid3
import Adapter.RecycleAdapter_ProductList_3_filter
import ModalClass.BeanClassForProductList

class ProductGridList3 : AppCompatActivity() {


    private val title = arrayOf("Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)")


    private var beanClassForProductLists: ArrayList<BeanClassForProductList>? = null

    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecycleAdapter_ProductListGrid3? = null

    internal lateinit var filterrecyclerview: RecyclerView
    private var gridList_3_filter: RecycleAdapter_GridList_3_filter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_grid_list3)


        filterrecyclerview = findViewById(R.id.filterrecyclerview) as RecyclerView
        recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        beanClassForProductLists = ArrayList()


        beanClassForProductLists = ArrayList()

        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB Golden And Silver", R.drawable.white))

        mAdapter = RecycleAdapter_ProductListGrid3(this@ProductGridList3, beanClassForProductLists!!)

        val mLayoutManager = GridLayoutManager(this@ProductGridList3, 2)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter




        gridList_3_filter = RecycleAdapter_GridList_3_filter(this@ProductGridList3)
        val mLayoutManager11 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        filterrecyclerview.layoutManager = mLayoutManager11
        filterrecyclerview.itemAnimator = DefaultItemAnimator()
        filterrecyclerview.adapter = gridList_3_filter
    }
}
