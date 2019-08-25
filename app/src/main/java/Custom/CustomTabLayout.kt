package Custom


import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.ViewGroup

import java.security.AccessController.getContext

/**
 * Created by praja on 22-Apr-17.
 */

class CustomTabLayout : TabLayout {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun setTabsFromPagerAdapter(adapter: PagerAdapter?) {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/Roboto-Medium.ttf")

        this.removeAllTabs()

        val slidingTabStrip = getChildAt(0) as ViewGroup

        var i = 0
        val count = adapter?.count
        while (i < count!!) {
            val tab = this.newTab()
            this.addTab(tab.setText(adapter.getPageTitle(i)))
            val view = (slidingTabStrip.getChildAt(i) as ViewGroup).getChildAt(1) as AppCompatTextView
            view.setTypeface(typeface, Typeface.NORMAL)
            i++
        }
    }
}
