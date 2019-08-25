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


import ModalClass.Home1_TredingModalClass
import ModalClass.Home3_ProductModalClass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_home_3_Products(internal var mContext: Context, private val modalClassList: List<Home3_ProductModalClass>) : RecyclerView.Adapter<RecycleviewAdapter_home_3_Products.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var img: ImageView
        internal var heading: TextView
        internal var subtext: TextView
        internal var price: TextView


        init {


            img = view.findViewById(R.id.img) as ImageView
            heading = view.findViewById(R.id.heading) as TextView
            subtext = view.findViewById(R.id.subtext) as TextView
            price = view.findViewById(R.id.price) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product__home3_list, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = modalClassList[position]
        holder.heading.text = list.heading
        holder.subtext.text = list.subtext
        holder.img.setImageResource(list.image)
        holder.price.text = "" + list.price
    }

    override fun getItemCount(): Int {
        return modalClassList.size
    }


}


