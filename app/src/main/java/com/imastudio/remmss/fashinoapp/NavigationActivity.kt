package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.MenuItem

import java.util.ArrayList

import Adapter.RecycleviewAdapter_navigation
import ModalClass.NavigationModalclass
import android.annotation.SuppressLint

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigation_recycleview: RecyclerView
    internal var mContext: Context? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private lateinit var navigationView: NavigationView
    private var adapter_navigation: RecycleviewAdapter_navigation? = null

    private var navigationModalclassArrayList: ArrayList<NavigationModalclass>? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        navigation_recycleview = findViewById(R.id.navigation_recycleview) as RecyclerView
        drawer = findViewById(R.id.drawer_layout) as DrawerLayout

        navigationView = findViewById(R.id.navigation_view) as NavigationView
        setToolbar()
        navigationModalclassArrayList = ArrayList()


        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_computer, "Computer"))
        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_laptop, "Laptops"))
        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_accessories, "Accessories"))
        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_phone, "Phones"))
        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_tv, "TV"))
        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_watches, "Watches"))
        navigationModalclassArrayList!!.add(NavigationModalclass(R.drawable.ic_game, "Games"))

        adapter_navigation = RecycleviewAdapter_navigation(this.mContext!!, navigationModalclassArrayList!!)
        val mLayoutManager = LinearLayoutManager(this)
        navigation_recycleview.layoutManager = mLayoutManager
        navigation_recycleview.adapter = adapter_navigation



        actionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

        }

        drawer!!.setDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle!!.syncState()
        actionBarDrawerToggle!!.isDrawerIndicatorEnabled = false

        invalidateOptionsMenu()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle!!.onConfigurationChanged(newConfig)
    }

    @SuppressLint("RtlHardcoded")
    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {

            drawer!!.closeDrawer(Gravity.LEFT) //OPEN Nav Drawer!
        } else {
            finish()
        }
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar!!.title = ""

        toolbar = findViewById(R.id.navigation_menu)

        toolbar?.setOnClickListener {
            Log.e("Click", "keryu")

            if (drawer?.isDrawerOpen(navigationView)!!) {
                drawer?.closeDrawer(navigationView)
            } else {
                drawer?.openDrawer(navigationView)
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
