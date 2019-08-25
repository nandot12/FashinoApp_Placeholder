package Adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



import ModalClass.FashinoList
import com.imastudio.remmss.fashinoapp.*
import com.imastudio.remmss.fashinoapp.detailProduk.ProductDetailActivity
import com.imastudio.remmss.fashinoapp.detailProdukkategori.ProductListActivity
import com.imastudio.remmss.fashinoapp.home.produk.HomePageActivity
import com.imastudio.remmss.fashinoapp.signIn.LoginActivity
import com.imastudio.remmss.fashinoapp.signUp.SignUpActivity


/**
 * Created by Rp on 6/14/2016.
 */
class RecycleviewAdapter_FashinoList(fashinoListActivity: FashinoListActivity, private val fashinoLists: List<FashinoList>) : RecyclerView.Adapter<RecycleviewAdapter_FashinoList.MyViewHolder>() {

    internal var mContext: Context
    internal var fashinoListActivity: FashinoListActivity? = null


    init {
        this.mContext = fashinoListActivity
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        internal var name: TextView


        init {


            name = view.findViewById(R.id.txt) as TextView

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fashino_list, parent, false)



        return MyViewHolder(itemView)


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = fashinoLists[position]
        holder.name.text = list.fashinoListName

        holder.itemView.setOnClickListener {
            if (position == 0) {

                val i = Intent(mContext, MainActivity::class.java)
                mContext.startActivity(i)

            } else if (position == 1) {

              //  val i = Intent(mContext, HomePage_1_Activity::class.java)
               // mContext.startActivity(i)

            } else if (position == 2) {

                val i = Intent(mContext, HomePageActivity::class.java)
                mContext.startActivity(i)

            } else if (position == 3) {

               // val i = Intent(mContext, HomePage_3_Activity::class.java)
               // mContext.startActivity(i)
            } else if (position == 4) {

                val i = Intent(mContext, NavigationActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 5) {

                val i = Intent(mContext, Navigation_1_Activity::class.java)
                mContext.startActivity(i)
            } else if (position == 6) {

                val i = Intent(mContext, NavigationActivity_3::class.java)
                mContext.startActivity(i)
            } else if (position == 7) {

                val i = Intent(mContext, ProductListActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 8) {

                val i = Intent(mContext, Product_List_2_Activity::class.java)
                mContext.startActivity(i)
            } else if (position == 9) {

                val i = Intent(mContext, Product_List_3_Activity::class.java)
                mContext.startActivity(i)
            } else if (position == 10) {

                val i = Intent(mContext, Product_List_Grid::class.java)
                mContext.startActivity(i)
            } else if (position == 11) {

                val i = Intent(mContext, Product_List_Grid_2::class.java)
                mContext.startActivity(i)
            } else if (position == 12) {

                val i = Intent(mContext, ProductGridList3::class.java)
                mContext.startActivity(i)
            } else if (position == 13) {

                val i = Intent(mContext, Filter_Activity::class.java)
                mContext.startActivity(i)
            } else if (position == 14) {

                val i = Intent(mContext, ProductDetailActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 15) {

                val i = Intent(mContext, WishListActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 16) {

                val i = Intent(mContext, WishlistEmptyActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 17) {

                val i = Intent(mContext, SignUpActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 18) {

                val i = Intent(mContext, LoginActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 19) {

                val i = Intent(mContext, ProductDetailActivity::class.java)
                mContext.startActivity(i)
            } else if (position == 20) {

                val i = Intent(mContext, ProductDetail_2_Activity::class.java)
                mContext.startActivity(i)
            } else if (position == 21) {

                val i = Intent(mContext, OrderTrackingActivity::class.java)
                mContext.startActivity(i)
            }
        }
    }

    override fun getItemCount(): Int {
        return fashinoLists.size
    }


}


