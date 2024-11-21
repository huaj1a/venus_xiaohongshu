package com.venus.xiaohongshu.ui.home

import androidx.compose.runtime.Composable
import com.venus.xiaohongshu.base.BaseComposeFragment
import com.venus.xiaohongshu.ui.home.composable.HomeScreen

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class HomeFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        HomeScreen()
    }
}