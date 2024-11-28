package com.venus.xiaohongshu.activity.video.composable

import android.content.Context
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/28
 */
@OptIn(UnstableApi::class)
@Composable
fun VenusPlayer(context: Context, raw: Int) {
    val playerState = remember { 
        ExoPlayer.Builder(context) 
            .build()
            .apply {
                this.setMediaItem(MediaItem.fromUri(Uri.parse("android.resource://${context.packageName}/${raw}")))
                this.prepare()
            }
    }
    playerState.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    playerState.repeatMode = Player.REPEAT_MODE_ONE
    playerState.playWhenReady = true
    
    AndroidView(
        factory = {
            PlayerView(it).apply {
                useController = false
                player = playerState
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {}
    
    DisposableEffect(key1 = raw) {
        onDispose { 
            playerState.release()
        }
    }
}