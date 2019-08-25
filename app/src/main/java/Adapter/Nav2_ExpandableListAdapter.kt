package Adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.imastudio.remmss.fashinoapp.R


import java.util.HashMap



class Nav2_ExpandableListAdapter(private val _context: Context, private val _listDataHeader: List<String> // header titles
                                 ,
        // child data in format of header title, child title
                                 private val _listDataChild: HashMap<String, List<String>>) : BaseExpandableListAdapter() {


    override fun getGroupCount(): Int {
        return this._listDataHeader.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this._listDataChild[this._listDataHeader[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return this._listDataHeader[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return this._listDataChild[this._listDataHeader[groupPosition]]?.get(childPosititon)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return 0
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.list_group, null)
        }


        val lblListHeader = convertView!!
                .findViewById(R.id.lblListHeader) as TextView

        val indicatorImg = convertView
                .findViewById(R.id.indicatorImg) as ImageView



        if (isExpanded) {
            indicatorImg.setImageResource(R.drawable.ic_up1)
        } else {
            indicatorImg.setImageResource(R.drawable.ic_down1)
        }



        lblListHeader.text = headerTitle
        val regular = Typeface.createFromAsset(_context.assets, "fonts/HelveticaNeue Medium.ttf")
        lblListHeader.typeface = regular
        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        run {

            val childText = getChild(groupPosition, childPosition) as String

            if (convertView == null) {
                val infalInflater = this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = infalInflater.inflate(R.layout.item_child_group, null)
            }

            val txtListChild = convertView!!
                    .findViewById(R.id.lblListItem) as TextView

            txtListChild.text = childText
            val regular = Typeface.createFromAsset(_context.assets, "fonts/HelveticaNeue Medium.ttf")
            txtListChild.typeface = regular
            return convertView!!
        }


    }


    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}