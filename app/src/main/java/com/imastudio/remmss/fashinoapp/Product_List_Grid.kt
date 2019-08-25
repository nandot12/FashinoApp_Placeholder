package com.imastudio.remmss.fashinoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import Adapter.RecycleAdapter_ProductListGrid
import ModalClass.BeanClassForProductList


class Product_List_Grid : AppCompatActivity() {

    private val title = arrayOf("Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)")


    private var beanClassForProductLists: ArrayList<BeanClassForProductList>? = null

    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecycleAdapter_ProductListGrid? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product__list__grid)


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

        mAdapter = RecycleAdapter_ProductListGrid(this@Product_List_Grid, beanClassForProductLists!!)

        val mLayoutManager = GridLayoutManager(this@Product_List_Grid, 2)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter
    }
}
