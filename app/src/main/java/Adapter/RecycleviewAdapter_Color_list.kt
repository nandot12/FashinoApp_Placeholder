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

import ModalClass.CategoryModalClass
import ModalClass.ColorModalClass

import com.imastudio.remmss.fashinoapp.FashinoListActivity
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_Color_list(internal var mContext: Context, private val colorModalClasses: List<ColorModalClass>) : RecyclerView.Adapter<RecycleviewAdapter_Color_list.MyViewHolder>() {
    internal var fashinoListActivity: FashinoListActivity? = null

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var colorid: ImageView


        init {


            colorid = view.findViewById(R.id.colorid) as ImageView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_color_list, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = colorModalClasses[position]
        holder.colorid.setImageResource(list.image)
    }

    override fun getItemCount(): Int {
        return colorModalClasses.size
    }


}


