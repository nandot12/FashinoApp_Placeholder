package com.imastudio.remmss.fashinoapp.detailProdukkategori

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.imastudio.remmss.fashinoapp.detailProduk.ProductDetailActivity

import com.imastudio.remmss.fashinoapp.detailProdukkategori.adapter.ProdukPerKategoriAdapter
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.detailProdukkategori.model.ResultProdukPerKategori
import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.DataItem
import com.imastudio.remmss.fashinoapp.network.ConfigNetwork
import com.imastudio.remmss.fashinoapp.utils.Constans
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_product_list.*
import org.jetbrains.anko.startActivity

class ProductListActivity : AppCompatActivity() {


    private var disposable: CompositeDisposable? = null
    private var id: String? = null


    private var mAdapter: ProdukPerKategoriAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)


        initIntent()
        getData()


    }

    private fun initIntent() {

        id = intent.getStringExtra(Constans.ID)
    }

    private fun getData() {

        disposable = CompositeDisposable()

        disposable?.add(ConfigNetwork.retrofit.getProdukPerkategori(id ?: "")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation()).subscribe({

                    t: ResultProdukPerKategori? ->
                    showData(t?.data)
                }, {}))


    }

    fun showData(data: List<DataItem>?) {

        if (data?.size ?: 0 > 0) {

            noItemtext.visibility = View.GONE

            mAdapter = ProdukPerKategoriAdapter(this, data, object : ProdukPerKategoriAdapter.onItemclickData {
                override fun onItemclick(data: DataItem?) {
                    startActivity<ProductDetailActivity>(Constans.PRODUK to data)
                }
            })
            product_recyclerview?.adapter = mAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.clear()
    }


}
