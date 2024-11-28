package com.venus.xiaohongshu.activity.graphic.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venus.xiaohongshu.activity.graphic.GraphicViewModel
import com.venus.xiaohongshu.ui.common.Divider

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/28
 */
@Composable
fun GraphicScreen() {
    val vm = viewModel<GraphicViewModel>()
    Scaffold(
        containerColor = Color.White
    ) { innerPadding -> 
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) { 
            GraphicTopBar(vm)

            GraphicBody(
                vm = vm,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 10.dp)
            )
            
            Divider()
            GraphicBottomBar(vm)
        }
    }
}