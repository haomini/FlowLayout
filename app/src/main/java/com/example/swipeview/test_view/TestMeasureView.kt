package com.example.swipeview.test_view

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 *
 * @author zhouhao
 * @since 2019/02/23
 */
class TestMeasureView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 测量自己的尺寸
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        /*// 获取测量到的尺寸
        val newSquare = if (measuredWidth > measuredHeight) {
            measuredHeight
        } else {
            measuredWidth
        }
        setMeasuredDimension(newSquare, newSquare)*/
    }
}