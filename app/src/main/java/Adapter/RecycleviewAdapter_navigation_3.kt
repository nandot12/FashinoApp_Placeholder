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


import ModalClass.NavigationModalclass
import ModalClass.Navigation_3Modalclass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_navigation_3(internal var mContext: Context, private val modalClassList: List<Navigation_3Modalclass>) : RecyclerView.Adapter<RecycleviewAdapter_navigation_3.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var img: ImageView
        internal var name: TextView


        init {


            img = view.findViewById(R.id.img) as ImageView
            name = view.findViewById(R.id.name) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_navigation_3, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = modalClassList[position]
        holder.name.text = list.name

    }

    override fun getItemCount(): Int {
        return modalClassList.size
    }


}


