package customfonts

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ScrollView

import com.imastudio.remmss.fashinoapp.R

import java.util.ArrayList

class StickyScrollView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = android.R.attr.scrollViewStyle) : NestedScrollView(context, attrs, defStyle) {

    private var stickyViews: ArrayList<View>? = null
    private var currentlyStickingView: View? = null
    private var stickyViewTopOffset: Float = 0.toFloat()
    private var stickyViewLeftOffset: Int = 0
    private var redirectTouchesToStickyView: Boolean = false
    private var clippingToPadding: Boolean = false
    private var clipToPaddingHasBeenSet: Boolean = false

    private var mShadowHeight: Int = 0
    private var mShadowDrawable: Drawable? = null

    private val invalidateRunnable = object : Runnable {

        override fun run() {
            if (currentlyStickingView != null) {
                val l = getLeftForViewRelativeOnlyChild(currentlyStickingView)
                val t = getBottomForViewRelativeOnlyChild(currentlyStickingView)
                val r = getRightForViewRelativeOnlyChild(currentlyStickingView)
                val b = (scrollY + (currentlyStickingView!!.height + stickyViewTopOffset)).toInt()
                invalidate(l, t, r, b)
            }
            postDelayed(this, 16)
        }
    }

    private var hasNotDoneActionDown = true

    init {
        setup()


        val a = context.obtainStyledAttributes(attrs,
                R.styleable.StickyScrollView, defStyle, 0)

        val density = context.resources.displayMetrics.density
        val defaultShadowHeightInPix = (DEFAULT_SHADOW_HEIGHT * density + 0.5f).toInt()

        mShadowHeight = a.getDimensionPixelSize(
                R.styleable.StickyScrollView_stuckShadowHeight,
                defaultShadowHeightInPix)

        val shadowDrawableRes = a.getResourceId(
                R.styleable.StickyScrollView_stuckShadowDrawable, -1)

        if (shadowDrawableRes != -1) {
            mShadowDrawable = context.resources.getDrawable(
                    shadowDrawableRes)
        }

        a.recycle()

    }

    /**
     * Sets the height of the shadow drawable in pixels.
     *
     * @param height
     */
    fun setShadowHeight(height: Int) {
        mShadowHeight = height
    }


    fun setup() {
        stickyViews = ArrayList()
    }

    private fun getLeftForViewRelativeOnlyChild(v: View?): Int {
        var v = v
        var left = v!!.left
        while (v!!.parent !== getChildAt(0)) {
            v = v!!.parent as View
            left += v.left
        }
        return left
    }

    private fun getTopForViewRelativeOnlyChild(v: View?): Int {
        var v = v
        var top = v!!.top
        while (v!!.parent !== getChildAt(0)) {
            v = v!!.parent as View
            top += v.top
        }
        return top
    }

    private fun getRightForViewRelativeOnlyChild(v: View?): Int {
        var v = v
        var right = v!!.right
        while (v!!.parent !== getChildAt(0)) {
            v = v!!.parent as View
            right += v.right
        }
        return right
    }

    private fun getBottomForViewRelativeOnlyChild(v: View?): Int {
        var v = v
        var bottom = v!!.bottom
        while (v!!.parent !== getChildAt(0)) {
            v = v!!.parent as View
            bottom += v.bottom
        }
        return bottom
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (!clipToPaddingHasBeenSet) {
            clippingToPadding = true
        }
        notifyHierarchyChanged()
    }

    override fun setClipToPadding(clipToPadding: Boolean) {
        super.setClipToPadding(clipToPadding)
        clippingToPadding = clipToPadding
        clipToPaddingHasBeenSet = true
    }

    override fun addView(child: View) {
        super.addView(child)
        findStickyViews(child)
    }

    override fun addView(child: View, index: Int) {
        super.addView(child, index)
        findStickyViews(child)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        super.addView(child, index, params)
        findStickyViews(child)
    }

    override fun addView(child: View, width: Int, height: Int) {
        super.addView(child, width, height)
        findStickyViews(child)
    }

    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        super.addView(child, params)
        findStickyViews(child)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        if (currentlyStickingView != null) {
            canvas.save()
            canvas.translate((paddingLeft + stickyViewLeftOffset).toFloat(), scrollY.toFloat() + stickyViewTopOffset + (if (clippingToPadding) paddingTop else 0).toFloat())

            canvas.clipRect(0f, if (clippingToPadding) -stickyViewTopOffset else 0,
                    (width - stickyViewLeftOffset).toFloat(),
                    (currentlyStickingView!!.height + mShadowHeight + 1).toFloat())

            if (mShadowDrawable != null) {
                val left = 0
                val right = currentlyStickingView!!.width
                val top = currentlyStickingView!!.height
                val bottom = currentlyStickingView!!.height + mShadowHeight
                mShadowDrawable!!.setBounds(left, top, right, bottom)
                mShadowDrawable!!.draw(canvas)
            }

            canvas.clipRect(0f, if (clippingToPadding) -stickyViewTopOffset else 0, width.toFloat(), currentlyStickingView!!.height.toFloat())
            if (getStringTagForView(currentlyStickingView)!!.contains(FLAG_HASTRANSPARANCY)) {
                showView(currentlyStickingView)
                currentlyStickingView!!.draw(canvas)
                hideView(currentlyStickingView)
            } else {
                currentlyStickingView!!.draw(canvas)
            }
            canvas.restore()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            redirectTouchesToStickyView = true
        }

        if (redirectTouchesToStickyView) {
            redirectTouchesToStickyView = currentlyStickingView != null
            if (redirectTouchesToStickyView) {
                redirectTouchesToStickyView = ev.y <= currentlyStickingView!!.height + stickyViewTopOffset &&
                        ev.x >= getLeftForViewRelativeOnlyChild(currentlyStickingView) &&
                        ev.x <= getRightForViewRelativeOnlyChild(currentlyStickingView)
            }
        } else if (currentlyStickingView == null) {
            redirectTouchesToStickyView = false
        }
        if (redirectTouchesToStickyView) {
            ev.offsetLocation(0f, -1 * (scrollY + stickyViewTopOffset - getTopForViewRelativeOnlyChild(currentlyStickingView)))
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if (redirectTouchesToStickyView) {
            ev.offsetLocation(0f, scrollY + stickyViewTopOffset - getTopForViewRelativeOnlyChild(currentlyStickingView))
        }

        if (ev.action == MotionEvent.ACTION_DOWN) {
            hasNotDoneActionDown = false
        }

        if (hasNotDoneActionDown) {
            val down = MotionEvent.obtain(ev)
            down.action = MotionEvent.ACTION_DOWN
            super.onTouchEvent(down)
            hasNotDoneActionDown = false
        }

        if (ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_CANCEL) {
            hasNotDoneActionDown = true
        }

        return super.onTouchEvent(ev)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        doTheStickyThing()
    }

    private fun doTheStickyThing() {
        var viewThatShouldStick: View? = null
        var approachingView: View? = null
        for (v in stickyViews!!) {
            val viewTop = getTopForViewRelativeOnlyChild(v) - scrollY + if (clippingToPadding) 0 else paddingTop
            if (viewTop <= 0) {
                if (viewThatShouldStick == null || viewTop > getTopForViewRelativeOnlyChild(viewThatShouldStick) - scrollY + if (clippingToPadding) 0 else paddingTop) {
                    viewThatShouldStick = v
                }
            } else {
                if (approachingView == null || viewTop < getTopForViewRelativeOnlyChild(approachingView) - scrollY + if (clippingToPadding) 0 else paddingTop) {
                    approachingView = v
                }
            }
        }
        if (viewThatShouldStick != null) {
            stickyViewTopOffset = (if (approachingView == null) 0 else Math.min(0, getTopForViewRelativeOnlyChild(approachingView) - scrollY + (if (clippingToPadding) 0 else paddingTop) - viewThatShouldStick.height)).toFloat()
            if (viewThatShouldStick !== currentlyStickingView) {
                if (currentlyStickingView != null) {
                    stopStickingCurrentlyStickingView()
                }
                // only compute the left offset when we start sticking.
                stickyViewLeftOffset = getLeftForViewRelativeOnlyChild(viewThatShouldStick)
                startStickingView(viewThatShouldStick)
            }
        } else if (currentlyStickingView != null) {
            stopStickingCurrentlyStickingView()
        }
    }

    private fun startStickingView(viewThatShouldStick: View) {
        currentlyStickingView = viewThatShouldStick
        if (getStringTagForView(currentlyStickingView)!!.contains(FLAG_HASTRANSPARANCY)) {
            hideView(currentlyStickingView)
        }
        if ((currentlyStickingView!!.tag as String).contains(FLAG_NONCONSTANT)) {
            post(invalidateRunnable)
        }
    }

    private fun stopStickingCurrentlyStickingView() {
        if (getStringTagForView(currentlyStickingView)!!.contains(FLAG_HASTRANSPARANCY)) {
            showView(currentlyStickingView)
        }
        currentlyStickingView = null
        removeCallbacks(invalidateRunnable)
    }

    /**
     * Notify that the sticky attribute has been added or removed from one or more views in the View hierarchy
     */
    fun notifyStickyAttributeChanged() {
        notifyHierarchyChanged()
    }

    private fun notifyHierarchyChanged() {
        if (currentlyStickingView != null) {
            stopStickingCurrentlyStickingView()
        }
        stickyViews!!.clear()
        findStickyViews(getChildAt(0))
        doTheStickyThing()
        invalidate()
    }

    private fun findStickyViews(v: View) {
        if (v is ViewGroup) {
            for (i in 0 until v.childCount) {
                val tag = getStringTagForView(v.getChildAt(i))
                if (tag != null && tag.contains(STICKY_TAG)) {
                    stickyViews!!.add(v.getChildAt(i))
                } else if (v.getChildAt(i) is ViewGroup) {
                    findStickyViews(v.getChildAt(i))
                }
            }
        } else {
            val tag = v.tag as String
            if (tag != null && tag.contains(STICKY_TAG)) {
                stickyViews!!.add(v)
            }
        }
    }

    private fun getStringTagForView(v: View?): String? {
        val tagObject = v!!.tag
        return tagObject.toString()
    }

    private fun hideView(v: View?) {
        if (Build.VERSION.SDK_INT >= 11) {
            v!!.alpha = 0f
        } else {
            val anim = AlphaAnimation(1f, 0f)
            anim.duration = 0
            anim.fillAfter = true
            v!!.startAnimation(anim)
        }
    }

    private fun showView(v: View?) {
        if (Build.VERSION.SDK_INT >= 11) {
            v!!.alpha = 1f
        } else {
            val anim = AlphaAnimation(0f, 1f)
            anim.duration = 0
            anim.fillAfter = true
            v!!.startAnimation(anim)
        }
    }


    fun setShadowDrawable(drawable: Drawable) {}

    companion object {

        /**
         * Tag for views that should stick and have constant drawing. e.g. TextViews, ImageViews etc
         */
        val STICKY_TAG = "sticky"

        /**
         * Flag for views that should stick and have non-constant drawing. e.g. Buttons, ProgressBars etc
         */
        val FLAG_NONCONSTANT = "-nonconstant"

        /**
         * Flag for views that have aren't fully opaque
         */
        val FLAG_HASTRANSPARANCY = "-hastransparancy"

        /**
         * Default height of the shadow peeking out below the stuck view.
         */
        private val DEFAULT_SHADOW_HEIGHT = 10 // dp;
    }
}

private fun Canvas.clipRect(fl: Float, any: Any, toFloat: Float, toFloat1: Float) {}
