package Adapter

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import ModalClass.BeanClassForProductList
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleAdapter_ProductList_3_filter(internal var context: Context) : RecyclerView.Adapter<RecycleAdapter_ProductList_3_filter.MyViewHolder>() {

    internal var showingFirst = true



    internal var NormalImageView: ImageView? = null
    internal var ImageBit: Bitmap? = null
    internal var ImageRadius = 40.0f


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal var txt_name: TextView

        init {

            txt_name = view.findViewById(R.id.txt_name) as TextView
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_filter_list, parent, false)



        return MyViewHolder(itemView)


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //  BeanClassForProductList movie = moviesList.get(position);
        // holder.txt_name.setText());


    }

    override fun getItemCount(): Int {
        return 1
    }


}


