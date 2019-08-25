package Adapter

import Adapter.WishlistAdapter.ViewHolder
import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imastudio.remmss.fashinoapp.R


import java.util.ArrayList

/**
 * Created by VICKY on 3/9/2017.
 */
class WishlistAdapter(list: List<String>, internal var context: Context) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    internal var list: List<String> = ArrayList()
    var mThumbIds = ArrayList<Int>()

    init {
        this.list = list
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var gridView: RecyclerView


        init {
            gridView = itemView.findViewById(R.id.gridviewwishlist) as RecyclerView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vv = LayoutInflater.from(parent.context).inflate(R.layout.wishlitdetail, parent, false)
        return ViewHolder(vv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mThumbIds.clear()
        mThumbIds.add(R.drawable.white)
        mThumbIds.add(R.drawable.white)
        mThumbIds.add(R.drawable.white)
        mThumbIds.add(R.drawable.white)
        val gridViewAdapter = GridAdapter(mThumbIds, context)
        val gridLayoutManager = GridLayoutManager(context, 2)
        holder.gridView.layoutManager = gridLayoutManager
        holder.gridView.adapter = gridViewAdapter
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

