package com.imastudio.remmss.fashinoapp

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView

import java.util.ArrayList
import java.util.HashMap

import Adapter.Nav2_ExpandableListAdapter
import Custom.ExpandableHeightExpandableListView

/**
 * Created by Remmss on 19-09-17.
 */

class Navigation_1_Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    internal lateinit var listAdapter: Nav2_ExpandableListAdapter
    internal lateinit var expListView: ExpandableListView
    internal lateinit var listDataHeader: MutableList<String>
    internal lateinit var listDataChild: HashMap<String, List<String>>
    internal lateinit var navigationView: NavigationView
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_1)

        drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.nav_view1) as NavigationView
        setToolbar()

        // get the listview
        expListView = findViewById(R.id.lvExp) as ExpandableListView

        // preparing list data
        prepareListData()

        listAdapter = Nav2_ExpandableListAdapter(this, listDataHeader, listDataChild)

        // setting list adapter
        expListView.setAdapter(listAdapter)



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
        actionBarDrawerToggle?.syncState()
        actionBarDrawerToggle?.isDrawerIndicatorEnabled = false

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

            if (drawer!!.isDrawerOpen(navigationView)) {
                drawer!!.closeDrawer(navigationView)
            } else {
                drawer!!.openDrawer(navigationView)
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = HashMap()

        // Adding child data
        listDataHeader.add("Brands")
        listDataHeader.add("Dail Needs")
        listDataHeader.add("Furniture")

        // Adding child data
        val top250 = ArrayList<String>()
        top250.add("Puma")
        top250.add("Adidas")
        top250.add("UCB")
        top250.add("Nike")
        top250.add("Veromoda")
        top250.add("Forever 21")

        val nowShowing = ArrayList<String>()
        nowShowing.add("Puma")
        nowShowing.add("Adidas")
        nowShowing.add("UCB")
        nowShowing.add("Nike")
        nowShowing.add("Veromoda")
        nowShowing.add("Forever 21")

        val comingSoon = ArrayList<String>()
        comingSoon.add("Puma")
        comingSoon.add("Adidas")
        comingSoon.add("UCB")
        comingSoon.add("Nike")
        comingSoon.add("Veromoda")
        comingSoon.add("Forever 21")

        listDataChild[listDataHeader[0]] = top250 // Header, Child data
        listDataChild[listDataHeader[1]] = nowShowing
        listDataChild[listDataHeader[2]] = comingSoon
    }

}
