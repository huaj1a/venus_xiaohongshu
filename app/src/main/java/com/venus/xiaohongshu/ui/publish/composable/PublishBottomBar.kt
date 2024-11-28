package com.venus.xiaohongshu.ui.publish.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.PrimaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.venus.xiaohongshu.R
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
@Composable
fun PublishBottomBar(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()
    val titleList = listOf("模板", "文字", "相册", "拍摄", "直播")
    Box {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TabRow(
                containerColor = Color.Black,
                modifier = Modifier,
                selectedTabIndex = pagerState.currentPage,
                divider = {},
                indicator = { tabPositions ->
                    PrimaryIndicator(
                        Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .height(3.dp),
                        color = colorResource(R.color.theme_red)
                    )
                }
            ) {
                titleList.forEachIndexed { index, title ->
                    Tab (
                        modifier = Modifier,
                        text = {
                            Text(
                                text = title,
                                color = if (pagerState.currentPage == index) Color.White
                                else colorResource(R.color.theme_text_gray)
                            )
                        },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }
        }
    }
}