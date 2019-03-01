package com.example.swipeview

import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

/**
 * @Describe 水平滑动ViewGroup
 * @Author zhouhao
 * @Date 2018/11/7
 * @Contact 605626708@qq.com
 */
class SwipeView : FrameLayout {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    fun <T> setAdapter(swipeAdapter: SwipeAdapter<T>) {

    }

    private fun init() {

    }

    /**
     * adapter
     */
    abstract class SwipeAdapter<T>(context: Context?, @LayoutRes val layoutId: Int, var data: List<T>) {
        abstract fun convert(holder: Holder, item: T, position: Int)

        abstract fun getCount(): Int
    }

    /**
     * holder
     */
    class Holder(private val view: View) {
        fun <T : View?> getView(@IdRes id: Int): T = view.findViewById<T>(id)
    }
}