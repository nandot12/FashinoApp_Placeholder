package com.imastudio.remmss.fashinoapp.detailProduk

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.data.Product
import com.imastudio.remmss.fashinoapp.data.database.ProductDatabase
import com.imastudio.remmss.fashinoapp.detailProdukkategori.model.ResultProdukPerKategori
import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.DataItem
import com.imastudio.remmss.fashinoapp.keranjang.KeranjangActivity
import com.imastudio.remmss.fashinoapp.utils.ChangeFormat
import com.imastudio.remmss.fashinoapp.utils.Constans
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_product_detail_1.*
import kotlinx.android.synthetic.main.toolbar_product_list.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.*


/**
 * Created by Remmss on 25-10-17.
 */

class ProductDetailActivity : AppCompatActivity() {


    internal var mContext: Context = this@ProductDetailActivity
    private var composite : CompositeDisposable? = null
    var dataItem : DataItem? = null
    private var database : ProductDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail_1)




             dataItem = intent.getSerializableExtra(Constans.PRODUK) as? DataItem

            tv_detailNameProduct.text = dataItem?.produkNama
            tv_detailPriceProduct.text = "Rp." + ChangeFormat.toRupiahFormat2(dataItem?.produkHarga ?: "")
            tv_detailprodukdesc.text = dataItem?.produkDesc
            tv_detailprodukratting.text = dataItem?.produkRatting

            Glide.with(this).load(Constans.BASE_URL_IMG + dataItem?.produkPhoto).into(img_detailProduk)

        composite = CompositeDisposable()

        database = ProductDatabase.getInstance(this)


        ic_keranjang.onClick {
            startActivity<KeranjangActivity>()
        }


        button_detailcart.onClick {

          //  toast("berhasil masuk keranjang")

            var produk = Product()
            produk.name = dataItem?.produkNama ?: ""
            produk.harga = dataItem?.produkHarga ?: ""
            produk.stok = dataItem?.produkStok ?: ""
            produk.categori = dataItem?.produkKategori ?: ""
            produk.desc = dataItem?.produkDesc ?: ""
            produk.id = System.currentTimeMillis()

            insertProduct(produk)


        }


    }

    private fun insertProduct(produk: Product) {

        //toast(produk.categori)



        async(UI) {

            bg {
                database?.productDao()?.insert(produk)

            }
        }

      //  Observable.fromCallable(() -> db.countriesDao().addCountries(countriesList))
//        composite?.add(Observable.fromCallable{ database?.productDao()?.insert(produk)
//        }.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    t ->
//                    //toast(t.toString())
//                },{
//                    t: Throwable? ->
//                  //  toast(t?.message ?: "")
//                   // toast(t?.localizedMessage ?: "")
//                  //  toast(t?.stackTrace.toString() ?: "")
//                }))


    }

    override fun onDestroy() {
        super.onDestroy()
        composite?.clear()
    }


}
