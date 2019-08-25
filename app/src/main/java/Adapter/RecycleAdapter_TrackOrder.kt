package Adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.github.vipulasri.timelineview.TimelineView

import ModalClass.BeanClassForProductList
import ModalClass.TrackModalClass
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleAdapter_TrackOrder(internal var context: Context, private val trackModalClasses: List<TrackModalClass>) : RecyclerView.Adapter<RecycleAdapter_TrackOrder.MyViewHolder>() {

    internal var showingFirst = true


    inner class MyViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

        val mTimelineView: TimelineView
        internal var title: TextView
        internal var phone_image: ImageView? = null

        init {
            title = itemView.findViewById(R.id.title) as TextView
            mTimelineView = itemView.findViewById(R.id.time_marker) as TimelineView
            mTimelineView.initLine(viewType)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_order_track, parent, false)
        return MyViewHolder(itemView, viewType)


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = trackModalClasses[position]
        holder.title.text = movie.title

        if (position == 4) {
            holder.mTimelineView.setMarkerColor(Color.parseColor("#BFBFBF"))
        }
        if (position == 0) {
            holder.mTimelineView.setStartLine(Color.parseColor("#6E7376"), 0)
        }

    }

    override fun getItemCount(): Int {
        return trackModalClasses.size
    }

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position, itemCount)
    }


}


