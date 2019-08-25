package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.ArrayList

import Adapter.RecycleviewAdapter_FashinoList
import ModalClass.FashinoList

class FashinoListActivity : AppCompatActivity() {


    private val Name = arrayOf("1. HomeScreen", "2. Home Page 1", "3. Home Page 2", "4. Home Page 3", "5. Navigation Activity", "6. Navigation 1 Activity", "7. Navigation 2 Activity", "8. Product List Activity", "9. Product List 2 Activity", "10. Product List 3 Activity", "11. Product Grid List", "12. Product Grid List 2", "13. Product Grid List 3", "14. Filter Activity", "15. Product Detail Activity", "16. WishList Activity", "17. WishList Empty Activity", "18. SignUp Activity", "19. Sign In Activity", "20. Product Detail Activity 1", "22. Product Detail Activity 2", "23. Order Track Activity")


    private var fashinoLists: ArrayList<FashinoList>? = null

    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecycleviewAdapter_FashinoList? = null
    internal var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fashino_list)



        recyclerView = findViewById(R.id.recyclerview) as RecyclerView
        fashinoLists = ArrayList()



        for (i in Name.indices) {
            val list = FashinoList(Name[i])

            fashinoLists!!.add(list)
        }


        mAdapter = RecycleviewAdapter_FashinoList(this@FashinoListActivity, fashinoLists!!)

        val mLayoutManager = LinearLayoutManager(this@FashinoListActivity)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter


    }
}
