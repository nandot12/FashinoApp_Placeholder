package com.imastudio.remmss.fashinoapp.home.produk

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager


import android.content.res.Configuration
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.imastudio.remmss.fashinoapp.ProductDetailActivity2
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.detailProduk.ProductDetailActivity
import com.imastudio.remmss.fashinoapp.detailProdukkategori.ProductListActivity
import com.imastudio.remmss.fashinoapp.home.produk.adapter.ClickOnItem
import com.imastudio.remmss.fashinoapp.network.ConfigNetwork
import com.imastudio.remmss.fashinoapp.home.produk.adapter.KategoriAdapter
import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.DataItem
import com.imastudio.remmss.fashinoapp.home.produk.adapter.ProdukAdapter
import com.imastudio.remmss.fashinoapp.profile.ProfileActivity
import com.imastudio.remmss.fashinoapp.utils.Constans
import com.synnapps.carouselview.ImageListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home_page_2.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class HomePageActivity : AppCompatActivity() {


    private var disposable: CompositeDisposable? = null
    private lateinit var navigationView: NavigationView
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var drawer: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    private var datas: List<com.imastudio.remmss.fashinoapp.home.produk.modelKategori.DataItem?>? = null


    private var adapter_home_2_headphone: ProdukAdapter? = null
    private var adapter_home_2_products: KategoriAdapter? = null

    internal var mContext: Context = this@HomePageActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_2)


        disposable = CompositeDisposable()
        drawer()

        array1()

        arrayKategori()


    }

    private fun arrayKategori() {


        disposable?.add(ConfigNetwork.retrofit.getKategori()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(

                        { t ->
                            if (t.sukses ?: true) showData(t.data)
                            else toast(t.pesan ?: "error")


                        },
                        { t: Throwable? ->
                            toast("error load")
                        }
                ))


    }

    private fun showData(data: List<com.imastudio.remmss.fashinoapp.home.produk.modelKategori.DataItem?>?) {

        if (data?.size ?: 0 > 0) {


            adapter_home_2_products = KategoriAdapter(this@HomePageActivity,
                    data, object : ClickOnItem {
                override fun onClick(id: String) {

                    startActivity<ProductListActivity>(Constans.ID to id)

                }
            })
            val mLayoutManager11 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            product_home_2_recycleview.layoutManager = mLayoutManager11
            product_home_2_recycleview.itemAnimator = DefaultItemAnimator()
            product_home_2_recycleview.adapter = adapter_home_2_products

            slide(data)

        } else {

        }

    }

    private fun array1() {

        disposable?.add(ConfigNetwork.retrofit.getProduk().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ t ->
                    if (t.sukses ?: true) toView(t.data)
                    else toast(t.pesan ?: getString(R.string.error_load))
                }, { t: Throwable? ->
                    toast(t?.message ?: "")
                }))


    }

    private fun toView(data: List<DataItem?>?) {

        if (data?.size ?: 0 > 0) {


            adapter_home_2_headphone = ProdukAdapter(this@HomePageActivity, data, object : ProdukAdapter.onItemDetail {
                override fun onItemclick(data: DataItem?) {

                    //ProductDetailActivity2

                    startActivity<ProductDetailActivity>(Constans.PRODUK to data)
                }
            })
            val mLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            home2_headphone_recycleview.layoutManager = mLayoutManager1
            home2_headphone_recycleview.itemAnimator = DefaultItemAnimator()
            home2_headphone_recycleview.adapter = adapter_home_2_headphone

        }


    }

    private fun drawer() {

        drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        navigationView = findViewById(R.id.nav_view1) as NavigationView

        val account = navigationView.findViewById<TextView>(R.id.navAccount)

        account.onClick {
            startActivity<ProfileActivity>()
        }

        setToolbar()





        actionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

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
        drawer?.setDrawerListener(actionBarDrawerToggle)

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


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBarDrawerToggle?.onConfigurationChanged(newConfig)
    }


    private fun setToolbar() {
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.title = ""

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setOnClickListener {

            if (drawer?.isDrawerOpen(navigationView) ?: true) {
                drawer?.closeDrawer(navigationView)
            } else {
                drawer?.openDrawer(navigationView)
            }
        }

    }

    private fun slide(data: List<com.imastudio.remmss.fashinoapp.home.produk.modelKategori.DataItem?>?) {

        datas = data


        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(data?.size ?: 0);

    }


    var imageListener = ImageListener { position, imageView ->

        Glide.with(this).load(Constans.BASE_URL_IMG + datas?.get(position)?.kategoriPhoto).into(imageView)

    }


    override fun onDestroy() {
        super.onDestroy()
        disposable?.clear()
    }


}
