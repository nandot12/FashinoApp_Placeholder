package Adapter

import Adapter.GridAdapter.ViewHolder
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


import com.imastudio.remmss.fashinoapp.R

import java.util.ArrayList

/**
 * Created by VICKY on 3/9/2017.
 */
class GridAdapter(list: List<Int>, internal var context: Context) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {
    internal var list: List<Int> = ArrayList()

    init {
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var imageview: ImageView

        init {
            imageview = itemView.findViewById(R.id.gridimage) as ImageView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vv = LayoutInflater.from(parent.context).inflate(R.layout.gridviewimage, parent, false)
        return ViewHolder(vv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageview.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

