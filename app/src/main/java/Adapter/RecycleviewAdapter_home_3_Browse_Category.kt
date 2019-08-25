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


import ModalClass.BrowseByCategoryModalClass
import ModalClass.Home1_TredingModalClass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_home_3_Browse_Category(internal var mContext: Context, private val modalClassList: List<BrowseByCategoryModalClass>) : RecyclerView.Adapter<RecycleviewAdapter_home_3_Browse_Category.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var image: ImageView
        internal var name: TextView


        init {


            image = view.findViewById(R.id.image) as ImageView
            name = view.findViewById(R.id.name) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_browse_by_category, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = modalClassList[position]
        holder.name.text = list.name
        holder.image.setImageResource(list.image)
    }

    override fun getItemCount(): Int {
        return modalClassList.size
    }


}


