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
import ModalClass.Home3_ProductModalClass
import ModalClass.NavigationModalclass
import com.imastudio.remmss.fashinoapp.R
import org.jetbrains.anko.sdk25.coroutines.onClick


class RecycleviewAdapter_navigation(var mContext: Context, val modalClassList: List<NavigationModalclass>) :
        RecyclerView.Adapter<RecycleviewAdapter_navigation.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_navigation_list, parent, false)
        return MyViewHolder(itemView)


    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = modalClassList[position]
        holder.name.text = list.name
        holder.img.setImageResource(list.img)
        holder.itemView.onClick {


            when(position){

                0 -> holder.itemView
            }

        }

    }

    override fun getItemCount(): Int {
        return modalClassList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var img: ImageView
        internal var name: TextView


        init {


            img = view.findViewById(R.id.img) as ImageView
            name = view.findViewById(R.id.name) as TextView

        }

    }


}


