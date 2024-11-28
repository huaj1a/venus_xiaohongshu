package com.venus.xiaohongshu.ui.home.city

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.activity.graphic.GraphicActivity
import com.venus.xiaohongshu.activity.video.VideoActivity
import com.venus.xiaohongshu.ui.home.bean.GraphicCardType
import com.venus.xiaohongshu.ui.home.composable.Shimmer

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityPage() {
    val vm = viewModel<CityViewModel>()
    val cityGraphicCardList = vm.cityGraphicCardList.observeAsState().value
    val pullToRefreshState = rememberPullToRefreshState()
    val context = LocalContext.current
    
    LaunchedEffect(pullToRefreshState.isRefreshing) {
        if (pullToRefreshState.isRefreshing) {
            vm.reload().join()
            pullToRefreshState.endRefresh()
        }
    }
    LaunchedEffect(Unit) {
        vm.load()
    }

    if (cityGraphicCardList?.isEmpty() != false) {
        Shimmer()
    } else {
        Box(modifier = Modifier.nestedScroll(pullToRefreshState.nestedScrollConnection)) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                content = {
                    cityGraphicCardList.forEachIndexed { _, data ->
                        item {
                            Column(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .background(color = Color.White, shape = RoundedCornerShape(3))
                                    .clickable {
                                        if (data.type == GraphicCardType.Graphic) {
                                            GraphicActivity.newInstance(context, data.id)
                                        } else {
                                            VideoActivity.newInstance(context, data.id)
                                        }
                                    }
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

            PullToRefreshContainer(
                state = pullToRefreshState,
                modifier = Modifier.align(Alignment.TopCenter),
                containerColor = colorResource(R.color.theme_background_gray),
                contentColor = colorResource(R.color.theme_red)
            )
        }
        
    }
}