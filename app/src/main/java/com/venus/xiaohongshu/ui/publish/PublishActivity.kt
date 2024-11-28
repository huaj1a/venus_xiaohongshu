package com.venus.xiaohongshu.ui.publish

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gyf.immersionbar.ImmersionBar
import com.venus.xiaohongshu.base.BaseComposeActivity
import com.venus.xiaohongshu.ui.publish.composable.PublishScreen
import com.venus.xiaohongshu.ui.publish.viewmodel.PublishViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class PublishActivity: BaseComposeActivity() {
    
    val vm: PublishViewModel by viewModels<PublishViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).init() // 设置状态栏文字为亮色
        var permission = Manifest.permission.READ_EXTERNAL_STORAGE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permission = Manifest.permission.READ_MEDIA_IMAGES
        }
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission, Manifest.permission.CAMERA), 1001)
        } else {
            vm.init(this)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001 
            && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            vm.init(this)
        }
    }
    
    @Composable
    override fun ComposeContent() {
        PublishScreen()
    }

}