package com.venus.xiaohongshu.ui.publish.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venus.xiaohongshu.ui.publish.album.AlbumPage
import com.venus.xiaohongshu.ui.publish.capture.CapturePage
import com.venus.xiaohongshu.ui.publish.live.LivePage
import com.venus.xiaohongshu.ui.publish.template.TemplatePage
import com.venus.xiaohongshu.ui.publish.text.TextPage
import com.venus.xiaohongshu.ui.publish.viewmodel.PublishViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
@Composable
fun PublishScreen() {
    val vm = viewModel<PublishViewModel>()
    val pagerState = rememberPagerState(initialPage = 2, pageCount = { 5 })
    val albumSelectList = vm.albumSelectList.observeAsState().value
    Scaffold(
        containerColor = Color.Black
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()),
            contentAlignment = Alignment.BottomCenter
        ) { 
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { 
                when(it) {
                    0 -> {
                        TemplatePage()
                    }
                    1 -> {
                        TextPage()
                    }
                    2 -> {
                        AlbumPage(
                            topPadding = innerPadding.calculateTopPadding(),
                            vm = vm
                        )
                    }
                    3 -> {
                        CapturePage()
                    }
                    4 -> {
                        LivePage()
                    }
                }
            }
            
            PublishBottomBar(pagerState)
            
            if (albumSelectList != null && albumSelectList.size > 0) {
                AlbumSelectBottomSheet(albumSelectList = albumSelectList, vm = vm)
            }
        }
    }
}

