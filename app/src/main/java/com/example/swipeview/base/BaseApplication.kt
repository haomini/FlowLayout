package com.example.swipeview.base

import android.app.Application

/**
 *
 * @author zhouhao
 * @since 2019/02/20
 */
class BaseApplication : Application() {

    override fun onCreate() {
        application = this
        super.onCreate()
    }

    companion object {
        lateinit var application: Application
    }
}