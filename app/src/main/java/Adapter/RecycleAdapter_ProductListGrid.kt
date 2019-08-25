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
class RecycleAdapter_ProductListGrid(internal var context: Context, private val moviesList: List<BeanClassForProductList>) : RecyclerView.Adapter<RecycleAdapter_ProductListGrid.MyViewHolder>() {

    internal var showingFirst = true


    internal var NormalImageView: ImageView? = null
    internal var ImageBit: Bitmap? = null
    internal var ImageRadius = 40.0f


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal var title: TextView
        internal var phone_image: ImageView

        init {

            title = view.findViewById(R.id.title) as TextView
            phone_image = view.findViewById(R.id.phone_image) as ImageView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_grid_list, parent, false)



        return MyViewHolder(itemView)


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.phone_image.setImageResource(movie.image)


    }

    override fun getItemCount(): Int {
        return moviesList.size
    }


}


