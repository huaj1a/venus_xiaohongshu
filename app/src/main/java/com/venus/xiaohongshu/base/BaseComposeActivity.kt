package com.venus.xiaohongshu.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
abstract class BaseComposeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { 
            ComposeContent()
        }
    }

    @Composable
    abstract fun ComposeContent()
}