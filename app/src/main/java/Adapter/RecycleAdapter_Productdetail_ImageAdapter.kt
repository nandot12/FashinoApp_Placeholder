package Adapter

import Adapter.RecycleAdapter_Productdetail_ImageAdapter.ViewHolder
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by VICKY on 3/9/2017.
 */
class RecycleAdapter_Productdetail_ImageAdapter(internal var context: Context) : RecyclerView.Adapter<RecycleAdapter_Productdetail_ImageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var imageview: ImageView? = null
        internal var areaname: TextView? = null
        internal var time: TextView? = null
        internal var date: TextView? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vv = LayoutInflater.from(parent.context).inflate(R.layout.item_image_productdetail, parent, false)
        return ViewHolder(vv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }
}

