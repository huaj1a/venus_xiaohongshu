package com.venus.xiaohongshu.ui.mine

import androidx.compose.runtime.Composable
import com.venus.xiaohongshu.base.BaseComposeFragment
import com.venus.xiaohongshu.ui.mine.composable.MineScreen

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class MineFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        MineScreen()
    }
}