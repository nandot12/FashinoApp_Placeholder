package com.imastudio.remmss.fashinoapp.keranjang.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.imastudio.remmss.fashinoapp.R
import com.imastudio.remmss.fashinoapp.data.Product
import com.imastudio.remmss.fashinoapp.utils.ChangeFormat
import com.imastudio.remmss.fashinoapp.utils.Constans
import kotlinx.android.synthetic.main.item_keranjang.view.*

class KeranjangAdapter(var context: Context, var data: List<Product>?) : RecyclerView.Adapter<KeranjangAdapter.MyHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)= MyHolder(LayoutInflater.from(context).inflate(R.layout.item_keranjang,p0,false))
    override fun getItemCount()= data?.size ?: 0
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position)) }
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Product?) {
            itemView.cart_name.text = get?.name
            itemView.cart_price.text = "Rp."+ChangeFormat.toRupiahFormat2(get?.harga ?: "")
            Glide.with(itemView.context).load(Constans.BASE_URL_IMG+get?.photo).into(itemView.cart_img)

        }

    }
}