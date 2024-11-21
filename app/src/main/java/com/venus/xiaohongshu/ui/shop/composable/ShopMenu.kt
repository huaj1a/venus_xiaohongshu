package com.venus.xiaohongshu.ui.shop.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.shop.viewmodel.ShopViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/19
 */
@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun ShopMenu(
    vm: ShopViewModel,
    modifier: Modifier
) {
    val listState = rememberLazyListState()
    var containerWidth by remember { mutableIntStateOf(0) }
    var maxScrollWidth by remember { mutableIntStateOf(0) } // 最大可以滑动的偏移量
    var oneItemOffset by remember { mutableIntStateOf(0) } // 一个item的偏移量大小
    var currentFirstItemIndex by remember { mutableIntStateOf(0) } // 当前第一个可见的item index
    var scrollPercent by remember { mutableDoubleStateOf(0.0) }
    
    LaunchedEffect(containerWidth) {
        oneItemOffset = listState.layoutInfo.visibleItemsInfo[1].offset
        val totalOffset = listState.layoutInfo.totalItemsCount * oneItemOffset
        maxScrollWidth = totalOffset - containerWidth
    }
    LaunchedEffect(listState) {
        val indexFlow = snapshotFlow { listState.firstVisibleItemIndex }
        val offsetFlow = snapshotFlow { listState.firstVisibleItemScrollOffset }
        combine(indexFlow, offsetFlow) { index, offset -> Pair(index, offset) }
            .distinctUntilChanged()
            .collect { (index, offset) ->
                currentFirstItemIndex = index
                scrollPercent = ((index * oneItemOffset) + offset) / maxScrollWidth.toDouble()
            }
    }
    
    Column(
        modifier = modifier.fillMaxWidth()
            .background(Color.White)
            .padding(bottom = 8.dp)
            .onSizeChanged {
                containerWidth = it.width
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            state = listState,
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(items = vm.menuList) { _, item ->
                Column (
                    modifier = Modifier.padding(16.dp)
                        .defaultMinSize(minWidth = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AsyncImage(
                        model = item.icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                            .padding(bottom = 4.dp)
                    )
                    Text(
                        text = item.title,
                        fontSize = 10.sp,
                    )
                }
            }
        }

        val outBoxWidth = 30.dp
        val innerBoxWidth = 18.dp
        Box(
            modifier = Modifier.size(outBoxWidth, 3.dp)
                .background(colorResource(R.color.theme_background_gray), RoundedCornerShape(10.dp))
        ) {
            Box(
                modifier = Modifier
                    .offset(x = ((outBoxWidth.value - innerBoxWidth.value) * scrollPercent).dp)
                    .size(innerBoxWidth, 3.dp)
                    .background(Color.Black, RoundedCornerShape(10.dp))

            )
        }
    }
}