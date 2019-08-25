package Adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import ModalClass.CategoryModalClass
import com.imastudio.remmss.fashinoapp.FashinoListActivity
import com.imastudio.remmss.fashinoapp.R


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_Category_list(internal var mContext: Context, private val categoryModalClasses: List<CategoryModalClass>) : RecyclerView.Adapter<RecycleviewAdapter_Category_list.MyViewHolder>() {
    internal var fashinoListActivity: FashinoListActivity? = null

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var txt_category_name: TextView


        init {


            txt_category_name = view.findViewById(R.id.txt_category_name) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category_list, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = categoryModalClasses[position]
        holder.txt_category_name.text = list.category_name
    }

    override fun getItemCount(): Int {
        return categoryModalClasses.size
    }


}


