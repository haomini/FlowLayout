package com.example.swipeview

import android.widget.Toast
import com.example.swipeview.base.BaseApplication

/**
 *
 * @author zhouhao
 * @since 2019/02/20
 */
class ToastUtils {

    companion object {

        private var toast: Toast? = null

        fun showToast(message: String) {
            if (toast == null) {
                toast = Toast.makeText(BaseApplication.application, message, Toast.LENGTH_SHORT)
            } else {
                toast!!.setText(message)
                toast!!.duration = Toast.LENGTH_SHORT
            }
            toast!!.show()
        }
    }
}