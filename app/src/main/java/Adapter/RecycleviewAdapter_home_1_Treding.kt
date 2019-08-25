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
import ModalClass.TredingModalClass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_home_1_Treding(internal var mContext: Context, private val modalClassList: List<Home1_TredingModalClass>) : RecyclerView.Adapter<RecycleviewAdapter_home_1_Treding.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var img: ImageView
        internal var txt_bag_name: TextView
        internal var txt_price: TextView


        init {


            img = view.findViewById(R.id.img) as ImageView
            txt_bag_name = view.findViewById(R.id.txt_bag_name) as TextView
            txt_price = view.findViewById(R.id.txt_price) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_treding__home1_list, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = modalClassList[position]
        holder.txt_bag_name.text = list.name
        holder.img.setImageResource(list.img)
        holder.txt_price.text = "" + list.price
    }

    override fun getItemCount(): Int {
        return modalClassList.size
    }


}


