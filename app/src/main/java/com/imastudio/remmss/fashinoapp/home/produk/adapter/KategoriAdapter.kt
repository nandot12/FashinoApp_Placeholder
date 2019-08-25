package com.imastudio.remmss.fashinoapp.home.produk.adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide


import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.utils.ChangeFormat
import com.imastudio.remmss.fashinoapp.utils.Constans
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * Created by Rp on 6/14/2016.
 */
class KategoriAdapter(internal var mContext: Context, private val modalClassList: List<com.imastudio.remmss.fashinoapp.home.produk.modelKategori.DataItem?>?,
                      val onclick : ClickOnItem) : RecyclerView.Adapter<KategoriAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var img: ImageView
        internal var txt_bag_name: TextView
        internal var txt_price: TextView
       internal var progress :ProgressBar
        internal  var ratting : RatingBar


        init {


            img = view.findViewById(R.id.img) as ImageView
            txt_bag_name = view.findViewById(R.id.txt_bag_name) as TextView
            txt_price = view.findViewById(R.id.txt_price) as TextView
            progress = view.findViewById(R.id.progress)
            ratting = view.findViewById(R.id.ratingbar)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fetured_product__home2_list, parent, false)





        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = (if (modalClassList != null) modalClassList else throw NullPointerException("Expression 'modalClassList' must not be null"))[position]
        holder.txt_bag_name.text = list?.kategoriNama

        val url = Constans.BASE_URL_IMG +list?.kategoriPhoto
        val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        holder.txt_price.visibility = View.GONE
        holder.ratting.visibility = View.GONE

        Glide.with(holder.itemView.context).load(url).error(R.drawable.no_image).placeholder(circularProgressDrawable).into(holder.img)

        holder.itemView.onClick {

            onclick.onClick(list?.kategoriId ?: "")
        }
    }

    override fun getItemCount(): Int {
        return if (modalClassList?.size != null) modalClassList?.size else throw NullPointerException("Expression 'modalClassList?.size' must not be null")
    }



}


