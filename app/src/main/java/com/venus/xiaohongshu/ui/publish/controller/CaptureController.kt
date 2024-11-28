package com.venus.xiaohongshu.ui.publish.controller

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Size
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
class CaptureController {

    var lensFacing = CameraSelector.LENS_FACING_BACK

    lateinit var preview: Preview
    lateinit var cameraxSelector: CameraSelector
    lateinit var cameraProvider: ProcessCameraProvider
    lateinit var imageCapture: ImageCapture

    fun init(context: Context, lifecycleOwner: LifecycleOwner, previewView: PreviewView) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        preview = Preview.Builder().build()
        imageCapture = ImageCapture.Builder()
            .setTargetResolution(Size(1080, 1920))
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
            .setJpegQuality(100)
            .build()
        cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context);
        cameraProviderFuture.addListener(
            {
                cameraProvider = cameraProviderFuture.get()
                preview.surfaceProvider = previewView.surfaceProvider
                cameraProvider.unbindAll();
                cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector, preview, imageCapture);
            }, ContextCompat.getMainExecutor(context))
    }

    @SuppressLint("RestrictedApi")
    fun release() {
        imageCapture.onUnbind()
    }

}