package com.venus.xiaohongshu.ui.home.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { 3 })
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            HomeDrawer()
        }
    ) {
        Scaffold(
            containerColor = Color.White,
        ) {  innerPadding ->
            Column(
                modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
            ) {
                HomeTopBar(
                    pagerState = pagerState,
                    drawerState = drawerState
                )

                HomeBody(
                    pagerState = pagerState
                )
            }
        }
    }
}



