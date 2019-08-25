package Adapter

import android.content.Context
import android.support.v4.view.PagerTitleStrip
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View

/**
 * Created by Wolf Soft on 12/13/2017.
 */

class WrapContentHeightViewPager : ViewPager {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasureSpec = heightMeasureSpec
        var pagerTitleStripHeight = 0
        var height = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height) {
                // get the measuredHeight of the tallest fragment
                height = h
            }
            if (child.javaClass == PagerTitleStrip::class.java) {
                // store the measured height of the pagerTitleStrip if one is found. This will only
                // happen if you have a android.support.v4.view.PagerTitleStrip as a direct child
                // of this class in your XML.
                pagerTitleStripHeight = h
            }
        }

        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height + pagerTitleStripHeight, View.MeasureSpec.EXACTLY)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
