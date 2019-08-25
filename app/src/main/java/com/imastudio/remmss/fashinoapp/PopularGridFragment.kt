package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import Adapter.RecycleAdapter_ProductListGrid
import Adapter.RecycleAdapter_ProductListGrid_2
import Adapter.RecycleAdapter_ProductList_2
import ModalClass.BeanClassForProductList

/**
 * Created by Remmss on 19-09-17.
 */

class PopularGridFragment : Fragment() {


    private val title = arrayOf("Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)", "Iphone 6S, 32GB (Golden and Silver)")


    private var beanClassForProductLists: ArrayList<BeanClassForProductList>? = null

    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecycleAdapter_ProductListGrid_2? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_grid_popular, container, false)

        recyclerView = view.findViewById(R.id.recyclerview) as RecyclerView
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


        mAdapter = activity?.let { RecycleAdapter_ProductListGrid_2(it, beanClassForProductLists!!) }

        val mLayoutManager = GridLayoutManager(activity, 2)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter


        return view

    }
}
