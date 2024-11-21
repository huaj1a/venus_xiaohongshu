package com.venus.xiaohongshu.ui.publish

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class PublishActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { 
            PublishScreen()
        }
    }
    
}