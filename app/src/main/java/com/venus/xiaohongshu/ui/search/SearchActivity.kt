package com.venus.xiaohongshu.ui.search

import androidx.compose.runtime.Composable
import com.venus.xiaohongshu.base.BaseComposeActivity
import com.venus.xiaohongshu.ui.search.composable.SearchScreen

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/18
 */
class SearchActivity: BaseComposeActivity() {
    
    @Composable
    override fun ComposeContent() {
        SearchScreen()
    }
    
}