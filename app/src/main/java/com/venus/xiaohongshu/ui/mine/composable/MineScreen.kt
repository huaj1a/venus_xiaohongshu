package com.venus.xiaohongshu.ui.mine.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venus.xiaohongshu.app.TAG
import com.venus.xiaohongshu.ui.mine.viewmodel.MineViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
const val initialImageFloat = 100f
@Composable
fun MineScreen() {
    val vm = viewModel<MineViewModel>()
    val scrollState = rememberScrollState(0)
    var topPadding by remember { mutableIntStateOf(0) }
    var mineTopBarHeight by remember { mutableIntStateOf(0) }
    var mineScrollingTopContentHeight by remember { mutableIntStateOf(Int.MAX_VALUE) }
    var scrollIntercept by remember { mutableStateOf(true) } // 是否拦截滑动事件
    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.value }
            .collect { value ->
                if (mineScrollingTopContentHeight - value <= topPadding + mineTopBarHeight) {
                    scrollIntercept = false
                } else {
                    scrollIntercept = true
                }
            }
    }
    val nestedScrollConnection = object : NestedScrollConnection {
        // 子View将要滚动时会触发此回调，返回值是父组件需要消耗的滚动值
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            Log.i(TAG, "scrollIntercept: $scrollIntercept")
            Log.i(TAG, "available: $available")
            if (scrollIntercept && available.y < 0) {
                scrollState.dispatchRawDelta(-available.y)
                return available
            }
            return super.onPreScroll(available, source)
        }
    }
    
    Scaffold(
        containerColor = Color.White
    ) { innerPadding ->
        with(LocalDensity.current) { topPadding = innerPadding.calculateTopPadding().toPx().toInt()}
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = scrollState)
                    .nestedScroll(nestedScrollConnection)
            ) {
                MineScrollingTopContent(
                    vm = vm,
                    scrollState = scrollState,
                    modifier = Modifier.onSizeChanged { 
                        mineScrollingTopContentHeight = it.height
                    }
                )
                BottomScrollingContent(
                    vm = vm
                )
            }
            if(!scrollIntercept) {
                Spacer(
                    modifier = Modifier
                        .height(with(LocalDensity.current) { mineTopBarHeight.toDp() } + innerPadding.calculateTopPadding())
                        .fillMaxWidth()
                        .background(Color(0xFF708090))
                )
            }
                
            MineTopBar(
                vm = vm,
                modifier = Modifier
                    .padding(top = innerPadding.calculateTopPadding())
                    .onSizeChanged {
                        mineTopBarHeight = it.height
                    },
                scrollState.value.toFloat()
            )
        }
    }
}
