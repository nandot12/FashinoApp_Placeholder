package com.imastudio.remmss.fashinoapp.detailProdukkategori.adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide


import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.home.produk.modelProduk.DataItem
import com.imastudio.remmss.fashinoapp.utils.ChangeFormat
import com.imastudio.remmss.fashinoapp.utils.Constans
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * Created by Rp on 6/14/2016.
 */
class ProdukPerKategoriAdapter(internal var context: Context, var produkList: List<DataItem>?, private val  itemclick: onItemclickData) : RecyclerView.Adapter<ProdukPerKategoriAdapter.MyViewHolder>() {

    internal var showingFirst = true





    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal var title: TextView
        internal var phone_image: ImageView
         var textHarga : TextView
        var ratting : RatingBar
        var textratting : TextView


        init {

            title = view.findViewById(R.id.title) as TextView
            phone_image = view.findViewById(R.id.phone_image) as ImageView
            textHarga = view.findViewById(R.id.itemPrice)
            ratting = view.findViewById(R.id.ratingbar)
            textratting = view.findViewById(R.id.textRatting)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_list, parent, false)



        return MyViewHolder(itemView)


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = produkList?.get(position)
        holder.title.text = data?.produkNama
        holder.textHarga.text = "Rp."+ChangeFormat.toRupiahFormat2(data?.produkHarga?: "")
        holder.ratting.numStars = data?.produkRatting?.toInt() ?: 0
        holder.textratting.text = data?.produkRatting
        Glide.with(holder.itemView.context)
                .load(Constans.BASE_URL_IMG+data?.produkPhoto)
                .into(holder.phone_image)

        holder.itemView.onClick {

            itemclick.onItemclick(data)
        }


    }

    override fun getItemCount(): Int {
        return produkList?.size ?: 0
    }

    interface onItemclickData{

        fun onItemclick(data: DataItem?)
    }


}


