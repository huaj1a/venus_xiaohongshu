package com.venus.xiaohongshu.ui.publish.capture

import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.venus.xiaohongshu.ui.publish.controller.CaptureController

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
@Composable
fun CapturePage() {
    val captureController = remember { 
        CaptureController()
    }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember {
        PreviewView(context)
    }
    LaunchedEffect(Unit) {
        captureController.init(context, lifecycleOwner, previewView)
    }
    DisposableEffect(Unit) {
        onDispose { 
            captureController.release()
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            {previewView},
            modifier = Modifier.fillMaxSize()
        )
    }
}