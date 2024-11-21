package com.venus.xiaohongshu.ui.shop.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.home.composable.Shimmer
import com.venus.xiaohongshu.ui.shop.viewmodel.ShopViewModel
import kotlin.random.Random

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/19
 */
@Composable
fun ShopBody(
    vm: ShopViewModel
) {
    val goodsList = vm.goodsList.observeAsState().value
    val maxHeight = LocalConfiguration.current.screenHeightDp.dp
    
    var menuScrollHeight by remember { mutableFloatStateOf(0f) } // 菜单的高度
    val scrollState = rememberScrollState()
    var scrollIntercept by remember { mutableStateOf(true) } // 父组件是否拦截滑动事件
    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.value }
            .collect { value ->
                // 如果Column滑动的距离小于菜单的高度，则拦截滑动事件，让Column进行滑动
                if (value > menuScrollHeight) {
                    scrollIntercept = false
                } else {
                    scrollIntercept = true
                }
            }
    }
    val nestedScrollConnection = object : NestedScrollConnection {
        // 子View将要滚动时会触发此回调，返回值是父组件需要消耗的滚动值
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            if (scrollIntercept && available.y < 0) {
                scrollState.dispatchRawDelta(-available.y)
                return available
            }
            return super.onPreScroll(available, source)
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .nestedScroll(nestedScrollConnection)
            .background(colorResource(R.color.theme_background_gray))
    ) { 
        
        ShopMenu(
            vm,
            modifier = Modifier.onSizeChanged { 
                menuScrollHeight = it.height.toFloat()
            }
        )
        
        if (goodsList?.isEmpty() != false) {
            Shimmer()
        } else {
            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .heightIn(max = maxHeight),
                columns = StaggeredGridCells.Fixed(2),
                content = {
                    // 直播卡片
                    (0..1).forEachIndexed { index, i ->  
                        item {
                            Column(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .background(brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color(0xFFFFE4E1), Color.White, Color(0xFFFFE4E1)
                                        )
                                    ), shape = RoundedCornerShape(3))
                                    .padding(8.dp)
                            ) {
                                if (index == 0) {
                                    Row { 
                                        Text(
                                            text = "直播精选",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.weight(1f))
                                        Text(
                                            text = "心动好物",
                                            fontSize = 12.sp,
                                            color = colorResource(R.color.theme_text_gray)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        LiveImage(image = R.drawable.p1)
                                        LiveImage(image = R.drawable.p10)
                                    }
                                } else {
                                    Row {
                                        Text(
                                            text = "不用比价",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.weight(1f))
                                        Text(
                                            text = "买贵必陪",
                                            fontSize = 12.sp,
                                            color = colorResource(R.color.theme_text_gray)
                                        )
                                    }

                                    Row(
                                        modifier = Modifier.fillMaxWidth()
                                            .padding(vertical = 20.dp),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        AsyncImage(
                                            model = R.drawable.icon_chenshan,
                                            contentDescription = null,
                                            modifier = Modifier.size(70.dp)
                                        )
                                        AsyncImage(
                                            model = R.drawable.icon_qunzi,
                                            contentDescription = null,
                                            modifier = Modifier.size(70.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    
                    // 商品列表
                    goodsList.forEachIndexed { _, goodsBean ->
                        item { 
                            Column(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .background(color = Color.White, shape = RoundedCornerShape(3))
                            ) { 
                                AsyncImage(
                                    model = goodsBean.image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(3, 3)),
                                    contentScale = ContentScale.Fit
                                )
                                
                                Text(
                                    text = goodsBean.title,
                                    modifier = Modifier.padding(6.dp)
                                )
                                
                                Row(
                                    modifier = Modifier.padding(horizontal = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) { 
                                    Text(
                                        text = "￥${"%.1f".format(goodsBean.price * goodsBean.discount)}"
                                    )
                                    
                                    Text(
                                        text = "￥${"%.1f".format(goodsBean.price)}",
                                        textDecoration = TextDecoration.LineThrough ,
                                        color = colorResource(R.color.theme_text_gray),
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(start = 6.dp)
                                    )
                                    
                                    Text(
                                        text = "${goodsBean.times}人买过",
                                        color = colorResource(R.color.theme_text_gray),
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(start = 6.dp)
                                    )
                                }
                                
                                Text(
                                    text = if(Random.nextInt(2) == 0) "假一赔十" else "退货包运费",
                                    Modifier
                                        .padding(6.dp)
                                        .border(
                                            width = 1.dp,
                                            color = colorResource(R.color.theme_text_gray)
                                        )
                                        .padding(vertical = 1.dp, horizontal = 3.dp)
                                    ,
                                    fontSize = 8.sp,
                                    color = colorResource(R.color.theme_text_gray)
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}