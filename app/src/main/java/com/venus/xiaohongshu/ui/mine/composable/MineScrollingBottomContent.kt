package com.venus.xiaohongshu.ui.mine.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.PrimaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.common.Divider
import com.venus.xiaohongshu.ui.mine.viewmodel.MineViewModel
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
@Composable
fun BottomScrollingContent(
    vm: MineViewModel
) {
    val maxHeight = LocalConfiguration.current.screenHeightDp.dp
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()
    val titleList = listOf("笔记", "收藏", "赞过")
    val graphicCardList = vm.graphicCardList.observeAsState().value
    
    LaunchedEffect(Unit) {
        vm.load()
    }
    
    Column(
        modifier = Modifier.fillMaxWidth()
    ) { 
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (tabRef, dividerRef) = remember { createRefs() }
            TabRow(
                containerColor = Color.White,
                modifier = Modifier
                    .constrainAs(tabRef) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .width(200.dp),
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
                                color = colorResource(R.color.theme_text_gray)
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
            
            Divider(
                modifier = Modifier.constrainAs(dividerRef) {
                    bottom.linkTo(parent.bottom)
                }
            )
        }
        
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(maxHeight)
        ) { page ->
            graphicCardList?.let { graphicCardList ->
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    content = {
                        graphicCardList.forEachIndexed { _, data ->
                            item {
                                Column(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .background(color = Color.White, shape = RoundedCornerShape(3))
                                ) {
                                    AsyncImage(
                                        model = data.image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(3, 3)),
                                        contentScale = ContentScale.Fit
                                    )

                                    Text(
                                        text = data.title,
                                        modifier = Modifier.padding(6.dp)
                                    )

                                    Row(
                                        modifier = Modifier.padding(start = 6.dp, end = 6.dp, bottom = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AsyncImage(
                                            model = data.user.image,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(16.dp)
                                                .clip(CircleShape)
                                        )
                                        Text(
                                            text = data.user.name,
                                            fontSize = 10.sp,
                                            color = colorResource(R.color.theme_text_gray),
                                            modifier = Modifier.padding(start = 6.dp)
                                        )
                                        Spacer(
                                            modifier = Modifier.weight(1f)
                                        )
                                        AsyncImage(
                                            model = R.drawable.icon_favorite,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(16.dp)
                                        )
                                        Text(
                                            text = data.likes.toString(),
                                            fontSize = 10.sp,
                                            color = colorResource(R.color.theme_text_gray),
                                            modifier = Modifier.padding(start = 6.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}