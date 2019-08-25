package Adapter

/**
 * Created by Wolf Soft on 11/24/2016.
 */


import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView

import com.imastudio.remmss.fashinoapp.R

import java.util.HashMap


class ExpandableListAdapter(private val _context: Context, private val _listDataHeader: List<String> // header titles
                            ,
        // child data in format of header title, child title
                            private val _listDataChild: HashMap<String, List<String>>) : BaseExpandableListAdapter() {


    private val lastExpandedPosition = -1

    private val lblListHeader: LinearLayout? = null
    private val line: LinearLayout? = null

    internal var lvExp: ExpandableListView? = null


    internal lateinit var btn1: RadioButton
    internal lateinit var btn2: RadioButton
    internal lateinit var btn3: RadioButton
    internal lateinit var btn4: RadioButton
    internal lateinit var btn5: RadioButton
    internal lateinit var btn6: RadioButton
    internal lateinit var btn7: RadioButton
    internal lateinit var btn8: RadioButton
    internal var btn9: RadioButton? = null
    internal var btn10: RadioButton? = null
    internal var btn11: RadioButton? = null

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return this._listDataChild[this._listDataHeader[groupPosition]]?.get(childPosititon)!!


    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView


        val childText = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.item_list, null)


            btn1 = convertView!!.findViewById(R.id.button1) as RadioButton
            btn2 = convertView.findViewById(R.id.button2) as RadioButton
            btn3 = convertView.findViewById(R.id.button3) as RadioButton
            btn4 = convertView.findViewById(R.id.button4) as RadioButton
            btn5 = convertView.findViewById(R.id.button5) as RadioButton
            btn6 = convertView.findViewById(R.id.button6) as RadioButton
            btn7 = convertView.findViewById(R.id.button7) as RadioButton
            btn8 = convertView.findViewById(R.id.button8) as RadioButton

            val font = Typeface.createFromAsset(_context.assets, "fonts/Roboto-Medium.ttf")

            btn1.text = "Apple"
            btn2.text = "Sony"
            btn3.text = "Asus"
            btn4.text = "LG"
            btn5.text = "Lenovo"
            btn6.text = "Samsung"
            btn7.text = "Xiaomi"
            btn8.text = "HTC"




            btn1.typeface = font
            btn2.typeface = font
            btn3.typeface = font

            btn4.typeface = font
            btn5.typeface = font
            btn6.typeface = font

            btn7.typeface = font
            btn8.typeface = font
        }

        val txtListChild = convertView
                .findViewById(R.id.lblListItem) as LinearLayout

        //        txtListChild.setText(childText);
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this._listDataChild[this._listDataHeader[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return this._listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return this._listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }


    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.list_group, null)
        }

        val lblListHeader = convertView!!
                .findViewById(R.id.lblListHeader) as TextView
        lblListHeader.text = headerTitle


        val lvExp = convertView
                .findViewById(R.id.lvExp) as ExpandableListView






        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }


}


