package com.example.swipeview.test_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

/**
 * Android FlowLayout
 * @author zhouhao
 * @since 2019/02/23
 */
class FlowLayout : ViewGroup {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val selfWidth = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        var totalHeight = paddingTop + paddingBottom
        var childLeft = paddingLeft
        var currentLineMaxHeight = 0
        for (index in 0 until childCount) {
            val childView = getChildAt(index)
            // Not visible
            if (childView.visibility == View.GONE) continue

            measureChild(childView, widthMeasureSpec, heightMeasureSpec)

            val layoutParams = childView.layoutParams as MarginLayoutParams
            val childWidth = childView.measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin
            val childHeight = childView.measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin

            when {
                // Last item
                childCount - 1 == index -> {
                    if (childLeft + childWidth > selfWidth - paddingRight) {
                        totalHeight += currentLineMaxHeight
                        totalHeight += childHeight
                    } else {
                        totalHeight += Math.max(currentLineMaxHeight, childHeight)
                    }
                }
                // A newline
                childLeft + childWidth > selfWidth - paddingRight -> {
                    totalHeight += currentLineMaxHeight
                    currentLineMaxHeight = childHeight
                    childLeft = paddingLeft + childWidth
                }
                // The current line
                else -> {
                    currentLineMaxHeight = Math.max(currentLineMaxHeight, childHeight)
                    childLeft += childWidth
                }
            }
        }
        setMeasuredDimension(selfWidth, totalHeight)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        var childLeft: Int = paddingLeft
        var childTop: Int = paddingTop
        var currentLineMaxHeight = 0

        for (index in 0 until childCount) {
            val childView = getChildAt(index)
            // Not visible
            if (childView.visibility == View.GONE) continue

            val layoutParams = childView.layoutParams as MarginLayoutParams
            val childWidth = childView.measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin
            val childHeight = childView.measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin

            childView.layout(
                childLeft + layoutParams.leftMargin,
                childTop + layoutParams.topMargin,
                childLeft + childWidth - layoutParams.rightMargin,
                childTop + childHeight - layoutParams.bottomMargin
            )
            childLeft += childWidth
            currentLineMaxHeight = Math.max(currentLineMaxHeight, childHeight)
            // Locate the next view
            if (index != childCount - 1) {
                val nextLayoutParams = getChildAt(index + 1).layoutParams as MarginLayoutParams
                val nextChildWidth =
                    getChildAt(index + 1).measuredWidth + nextLayoutParams.leftMargin + nextLayoutParams.rightMargin
                if (childLeft + nextChildWidth > right - left - paddingRight) {
                    childTop += currentLineMaxHeight
                    childLeft = paddingLeft
                    currentLineMaxHeight = 0
                }
            }
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet): ViewGroup.LayoutParams {
        return ViewGroup.MarginLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): ViewGroup.LayoutParams {
        return ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun generateLayoutParams(p: ViewGroup.LayoutParams): ViewGroup.LayoutParams {
        return ViewGroup.MarginLayoutParams(p)
    }
}