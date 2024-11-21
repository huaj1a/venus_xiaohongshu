package com.venus.xiaohongshu.ui.message

import androidx.compose.runtime.Composable
import com.venus.xiaohongshu.base.BaseComposeFragment
import com.venus.xiaohongshu.ui.message.composable.MessageScreen

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class MessageFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        MessageScreen()
    }
}