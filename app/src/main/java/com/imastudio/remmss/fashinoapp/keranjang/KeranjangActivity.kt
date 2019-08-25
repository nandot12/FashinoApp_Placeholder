package com.imastudio.remmss.fashinoapp.keranjang

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.data.Product
import com.imastudio.remmss.fashinoapp.data.database.ProductDatabase
import com.imastudio.remmss.fashinoapp.keranjang.adapter.KeranjangAdapter
import io.reactivex.disposables.CompositeDisposable

import kotlinx.android.synthetic.main.activity_keranjang.*
import kotlinx.android.synthetic.main.content_keranjang.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.toast

class KeranjangActivity : AppCompatActivity() {

    private var database : ProductDatabase?  = null

    private var composite : CompositeDisposable?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        composite = CompositeDisposable()
        database = ProductDatabase.getInstance(this)


     getData()
    }

    private fun getData() {

//        launch (UI){
//
//            var data = database?.productDao().getAll()
//            showData(data)
//        }

        async(UI){

           var data =  bg {
              database?.productDao()?.getAll()

            }.await()
            showData(data)


       }
//
//        showData(data)

//      launch(UI) {
//
//          var data = database?.productDao()?.getAll()
//          showData(data)
//      }
//        database?.productDao()?.getAll()?.subscribeOn(Schedulers.computation())
//                ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ t: List<Product>? ->
//                    showData(t)
//                })?.let { composite?.add(it) }


    }

    private fun showData(t: List<Product>?) {


        toast(t?.get(0)?.categori.toString())
        if(t?.size ?: 0 > 0){
            ada.visibility = View.VISIBLE
            ada2.visibility = View.VISIBLE
            textCart.visibility = View.GONE
            recyclerviewcart.adapter = KeranjangAdapter(this,t)


        }


    }

    override fun onDestroy() {
        super.onDestroy()

        composite?.clear()
    }


}
