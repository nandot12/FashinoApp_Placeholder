package Adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import ModalClass.BeanClassForProductList
import ModalClass.Home3_ProductModalClass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_Products_detail(internal var mContext: Context, private val moviesList: List<BeanClassForProductList>) : RecyclerView.Adapter<RecycleviewAdapter_Products_detail.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var phone_image: ImageView
        internal var title: TextView
      ///  internal var subtext: TextView
        internal var price: TextView


        init {


            phone_image = view.findViewById(R.id.phone_image) as ImageView
            title = view.findViewById(R.id.title) as TextView
//            subtext = view.findViewById(R.id.subtext) as TextView
            price = view.findViewById(R.id.price) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product_detail_list, parent, false)



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


