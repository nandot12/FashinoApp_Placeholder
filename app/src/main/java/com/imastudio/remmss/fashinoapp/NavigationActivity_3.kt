package com.imastudio.remmss.fashinoapp

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View

import java.util.ArrayList

import Adapter.RecycleviewAdapter_navigation
import Adapter.RecycleviewAdapter_navigation_3
import ModalClass.NavigationModalclass
import ModalClass.Navigation_3Modalclass

/**
 * Created by Remmss on 19-09-17.
 */

class NavigationActivity_3 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    internal lateinit var navigation_recycleview: RecyclerView
    internal var mContext: Context? = null

    private var adapter_navigation: RecycleviewAdapter_navigation_3? = null
    internal lateinit var navigationView: NavigationView
    private var navigationModalclassArrayList: ArrayList<Navigation_3Modalclass>? = null

    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_3)

        navigation_recycleview = findViewById(R.id.navigation_recycleview) as RecyclerView
        drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.navigation_view) as NavigationView
        setToolbar()


        navigationModalclassArrayList = ArrayList()


        navigationModalclassArrayList!!.add(Navigation_3Modalclass("Brands"))
        navigationModalclassArrayList!!.add(Navigation_3Modalclass("New Arrivals"))
        navigationModalclassArrayList!!.add(Navigation_3Modalclass("Track Order"))
        navigationModalclassArrayList!!.add(Navigation_3Modalclass("Mobile & Electronics"))
        navigationModalclassArrayList!!.add(Navigation_3Modalclass("Home & Living"))
        navigationModalclassArrayList!!.add(Navigation_3Modalclass("Daily Needs"))
        navigationModalclassArrayList!!.add(Navigation_3Modalclass("Furniture"))

        adapter_navigation = RecycleviewAdapter_navigation_3(mContext!!, navigationModalclassArrayList!!)
        val mLayoutManager = LinearLayoutManager(this)
        navigation_recycleview.layoutManager = mLayoutManager
        navigation_recycleview.adapter = adapter_navigation




        actionBarDrawerToggle = object :ActionBarDrawerToggle(this,drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                drawerView.let {

                    super.onDrawerClosed(it)
                }
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                super.onDrawerOpened(drawerView)
            }
        }

        //Setting the actionbarToggle to drawer layout
        drawer!!.setDrawerListener(actionBarDrawerToggle)

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle!!.syncState()
        actionBarDrawerToggle!!.isDrawerIndicatorEnabled = false

        invalidateOptionsMenu()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // toggle nav drawer on selecting action bar app icon/title
        return if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Pass any configuration change to the drawer toggls
        actionBarDrawerToggle!!.onConfigurationChanged(newConfig)
    }

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
