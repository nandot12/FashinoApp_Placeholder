package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import Adapter.RecycleAdapter_ProductList_2
import ModalClass.BeanClassForProductList

/**
 * Created by Remmss on 19-09-17.
 */

class PopularFragment : Fragment() {


    internal lateinit var popular_recycleview: RecyclerView
    private var beanClassForProductLists: ArrayList<BeanClassForProductList>? = null
    private var adapter_productList_2: RecycleAdapter_ProductList_2? = null
    internal var mContext: Context? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_popular, container, false)


        popular_recycleview = view.findViewById(R.id.popular_recycleview) as RecyclerView

        beanClassForProductLists = ArrayList()


        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))
        beanClassForProductLists!!.add(BeanClassForProductList("Iphone 6s 32GB (Golden And Silver)", R.drawable.white))

        adapter_productList_2 = RecycleAdapter_ProductList_2(mContext!!, beanClassForProductLists!!)
        val mLayoutManager = LinearLayoutManager(activity)
        popular_recycleview.layoutManager = mLayoutManager
        popular_recycleview.adapter = adapter_productList_2




        return view
    }
}
