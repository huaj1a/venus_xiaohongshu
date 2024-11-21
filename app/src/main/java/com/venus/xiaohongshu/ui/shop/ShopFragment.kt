package com.venus.xiaohongshu.ui.shop

import androidx.compose.runtime.Composable
import com.venus.xiaohongshu.base.BaseComposeFragment
import com.venus.xiaohongshu.ui.shop.composable.ShopScreen

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class ShopFragment: BaseComposeFragment() {
    @Composable
    override fun ComposeContent() {
        ShopScreen()
    }
}