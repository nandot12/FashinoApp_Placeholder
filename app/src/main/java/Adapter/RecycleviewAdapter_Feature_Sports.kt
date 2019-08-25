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


import ModalClass.TredingModalClass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_Feature_Sports(internal var mContext: Context, private val modalClassList: List<TredingModalClass>) : RecyclerView.Adapter<RecycleviewAdapter_Feature_Sports.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var img: ImageView
        internal var txt_shoes_name: TextView
        internal var rating: TextView
        internal var txt_price: TextView


        init {


            img = view.findViewById(R.id.img) as ImageView
            txt_shoes_name = view.findViewById(R.id.txt_shoes_name) as TextView
            rating = view.findViewById(R.id.rating) as TextView
            txt_price = view.findViewById(R.id.txt_price) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_treding_list, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = modalClassList[position]
        holder.txt_shoes_name.text = list.shoes_name
        holder.img.setImageResource(list.img)
        holder.rating.text = "" + list.rating
        holder.txt_price.text = "" + list.price
    }

    override fun getItemCount(): Int {
        return modalClassList.size
    }


}


