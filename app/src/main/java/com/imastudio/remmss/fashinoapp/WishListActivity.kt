package com.imastudio.remmss.fashinoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView


import java.util.ArrayList

import Adapter.WishlistAdapter

class WishListActivity : AppCompatActivity() {
    internal var toolbar: Toolbar? = null
    internal var toolbarback: ImageView? = null
    internal var toolbartext: TextView? = null
    internal lateinit var wishlistrecyclerview: RecyclerView
    internal var list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whishlist)
        wishlistrecyclerview = findViewById(R.id.wishlist) as RecyclerView
        // settoolbar();
        list.add("1")
        list.add("1")
        val linearLayoutManager = LinearLayoutManager(this@WishListActivity, LinearLayoutManager.VERTICAL, false)
        val wishlistAdapter = WishlistAdapter(list, this@WishListActivity)
        wishlistrecyclerview.layoutManager = linearLayoutManager
        wishlistrecyclerview.adapter = wishlistAdapter
    }

    /*  private void settoolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar1);;
        toolbarback=(ImageView) findViewById(R.id.back_arrow);
        toolbartext=(TextView) findViewById(R.id.toolbartext);

        toolbarback.setVisibility(View.GONE);
        toolbartext.setText("Wishlist");

    }*/
}
