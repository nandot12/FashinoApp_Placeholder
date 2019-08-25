package Adapter

import Adapter.RecycleAdapter_Color.ViewHolder
import android.content.Context
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.imastudio.remmss.fashinoapp.R


import java.util.ArrayList

/**
 * Created by VAIO on 4/27/2017.
 */

class RecycleAdapter_Color(list: List<String>, internal var context: Context) : RecyclerView.Adapter<RecycleAdapter_Color.ViewHolder>() {
    internal var list: List<String> = ArrayList()
    internal var selected_position = 0
    internal var color1 = intArrayOf(R.color.colorAccent, R.color.list2_1, R.color.list2_1)

    init {
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var color: ImageView
        internal var name: TextView? = null


        init {
            color = itemView.findViewById(R.id.colorid) as ImageView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vv = LayoutInflater.from(parent.context).inflate(R.layout.color_list, parent, false)
        return ViewHolder(vv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.color.background.setColorFilter(context.resources.getColor(color1[position]), PorterDuff.Mode.SRC_IN)
        if (selected_position == position) {
            // Here I am just highlighting the background
            holder.color.setImageResource(R.drawable.correct)
        } else {
            holder.color.setImageDrawable(null)
        }
        holder.color.setOnClickListener {
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
