package com.venus.xiaohongshu.ui.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.PrimaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.common.Divider
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
@Composable
fun HomeTopBar(
    pagerState: PagerState,
    drawerState: DrawerState
) {
    val coroutineScope = rememberCoroutineScope()
    val titleList = listOf("关注", "发现", "深圳")
    Box {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (drawerRef, tabRef, searchRef, dividerRef) = remember { createRefs() }

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

            Image(
                painter = painterResource(R.drawable.icon_menu),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(drawerRef) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(start = 16.dp)
                    .clickable {
                        coroutineScope.launch { 
                            drawerState.open()
                        }
                    }
            )

            Image(
                painter = painterResource(R.drawable.icon_search),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(searchRef) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(end = 16.dp)
                    .clickable {

                    }
            )
            
            Divider(
                modifier = Modifier
                    .constrainAs(dividerRef) {
                        top.linkTo(tabRef.bottom)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(top = 2.dp)
            )
        }
    }
}