package com.venus.xiaohongshu.app

import android.app.Application
import android.content.Context

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
const val TAG = "venus-xiaohongshu"
class AppApplication: Application() {
    
    companion object {
        lateinit var appContext: Context
            private  set
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}