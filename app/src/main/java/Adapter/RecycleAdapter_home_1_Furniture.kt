//package Adapter
//
//import android.content.Context
//import android.os.Build
//import android.support.annotation.RequiresApi
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//
//
//import ModalClass.Home1_TredingModalClass
//import com.imastudio.remmss.fashinoapp.R
//
///**
// * Created by Rp on 6/14/2016.
// */
//class RecycleAdapter_home_1_Furniture(mainActivityContacts: HomePage_1_Activity, private val modalClassList: List<Home1_TredingModalClass>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    internal var mContext: Context
//    internal var showingFirst = true
//
//    init {
//        this.mContext = mainActivityContacts
//    }
//
//    private inner class HeaderViewHolder(view: View)//  headerTitle = (TextView) view.findViewById(R.id.header_text);
//        : RecyclerView.ViewHolder(view) {
//        internal var headerTitle: TextView? = null
//    }
//
//
//    private inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        internal var img: ImageView
//        internal var txt_bag_name: TextView
//        internal var txt_price: TextView
//
//        init {
//            img = view.findViewById(R.id.img) as ImageView
//            txt_bag_name = view.findViewById(R.id.txt_bag_name) as TextView
//            txt_price = view.findViewById(R.id.txt_price) as TextView
//
//        }
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
//
//        if (viewType == TYPE_ITEM) {
//            //Inflating recycle view item layout
//            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_furniture__home1_list, parent, false)
//            return ItemViewHolder(itemView)
//        } else if (viewType == TYPE_HEADER) {
//            //Inflating header view
//            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_furniture_list1, parent, false)
//            return HeaderViewHolder(itemView)
//        } else
//            return null
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is HeaderViewHolder) {
//            val headerHolder = holder
//
//        }
//        var movie: Home1_TredingModalClass? = null
//        if (position != 0)
//            movie = modalClassList[position - 1]
//        if (holder is ItemViewHolder) {
//
//            holder.txt_bag_name.text = movie!!.name
//            holder.img.setImageResource(movie.img)
//            holder.txt_price.text = "" + movie.price
//
//
//            // Home1_TredingModalClass list = modalClassList.get(position);
//            /* ((ItemViewHolder) holder).txt_bag_name.setText(list.getName());
//            ((ItemViewHolder) holder).img.setImageResource(list.getImg());
//            ((ItemViewHolder) holder).txt_price.setText(""+list.getPrice());*/
//
//        }
//    }
//
//
//    override fun getItemCount(): Int {
//        return modalClassList.size + 1
//    }
//
//
//    override fun getItemViewType(position: Int): Int {
//        return if (isPositionHeader(position)) TYPE_HEADER else TYPE_ITEM
//    }
//
//    private fun isPositionHeader(position: Int): Boolean {
//        return position == 0
//    }
//
//    companion object {
//
//        private val TYPE_HEADER = 0
//        private val TYPE_ITEM = 1
//    }
//
//
//}
//
//
