package com.imastudio.remmss.fashinoapp.home.produk.adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide


import com.imastudio.remmss.fashinoapp.home.produk.HomePageActivity
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.DataItem
import com.imastudio.remmss.fashinoapp.utils.ChangeFormat
import com.imastudio.remmss.fashinoapp.utils.Constans
import kotlinx.android.synthetic.main.item_fetured_product__home2_list.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Rp on 6/14/2016.
 */

class ProdukAdapter(mainActivityContacts: HomePageActivity, private val modalClassList: List<DataItem?>?,var onItem: onItemDetail) : RecyclerView.Adapter<ProdukAdapter.MyHolder>() {

    internal var mContext: Context
    internal var showingFirst = true

    init {
        this.mContext = mainActivityContacts
    }



    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(get: DataItem?) {

            val circularProgressDrawable = CircularProgressDrawable(itemView.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()



            itemView.txt_bag_name.text= get?.produkNama
            val url = Constans.BASE_URL_IMG + get?.produkPhoto
            Glide.with(itemView.context).load(url).placeholder(circularProgressDrawable).error(R.drawable.no_image).into(itemView.img)
            itemView.txt_price.text = "Rp." + ChangeFormat.toRupiahFormat2(get?.produkHarga ?: "")


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fetured_product__home2_list, parent, false)
            return MyHolder(itemView)

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.bind(modalClassList?.get(position))

        holder.itemView.onClick {
            onItem.onItemclick(modalClassList?.get(position))
        }

    }


    override fun getItemCount(): Int {
        return modalClassList?.size ?: 0
    }

    interface onItemDetail{

        fun onItemclick(data: DataItem?)
    }






}


