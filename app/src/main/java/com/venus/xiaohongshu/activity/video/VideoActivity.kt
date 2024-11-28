package com.venus.xiaohongshu.activity.video

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.gyf.immersionbar.ImmersionBar
import com.venus.xiaohongshu.activity.graphic.KEY_ID
import com.venus.xiaohongshu.activity.video.composable.VideoScreen
import com.venus.xiaohongshu.base.BaseComposeActivity

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/22
 */
class VideoActivity: BaseComposeActivity() {
    private val vm: VideoViewModel by viewModels<VideoViewModel>()

    companion object {
        fun newInstance(context: Context, id: String) {
            val intent = Intent(context, VideoActivity::class.java)
            intent.putExtra(KEY_ID, id);
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).init() // 设置状态栏文字为亮色
        vm.id = intent.getStringExtra(KEY_ID) ?: ""
        vm.init()
    }
    
    @Composable
    override fun ComposeContent() {
        VideoScreen()
    }
}