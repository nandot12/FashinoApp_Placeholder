package Adapter

import Adapter.RecycleAdapter_Storage.ViewHolder
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.imastudio.remmss.fashinoapp.R

import java.util.ArrayList

/**
 * Created by VAIO on 4/27/2017.
 */

class RecycleAdapter_Storage(list: List<String>, internal var context: Context) : RecyclerView.Adapter<RecycleAdapter_Storage.ViewHolder>() {
    internal var list: List<String> = ArrayList()
    internal var selected_position = 0
    internal var color1 = intArrayOf(R.color.colorAccent, R.color.list2_1, R.color.list2_1, R.color.list2_1)

    init {
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var storage: TextView
        internal var name: TextView? = null


        init {
            storage = itemView.findViewById(R.id.storageid) as TextView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vv = LayoutInflater.from(parent.context).inflate(R.layout.storagelist, parent, false)
        return ViewHolder(vv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (selected_position == position) {
            // Here I am just highlighting the background
            holder.storage.background = ContextCompat.getDrawable(context, R.drawable.rectangle_blue_stroke)
            holder.storage.setTextColor(context.resources.getColor(R.color.blue))
        } else {
            holder.storage.background = ContextCompat.getDrawable(context, R.drawable.rectangle_viewline_stroke)
            holder.storage.setTextColor(context.resources.getColor(R.color.substr))

        }
        holder.storage.setOnClickListener {
            // Updating old as well as new positions
            notifyItemChanged(selected_position)
            selected_position = position
            notifyItemChanged(selected_position)

            // Do your another stuff for your onClick
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
