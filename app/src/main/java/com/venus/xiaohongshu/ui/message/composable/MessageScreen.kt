package com.venus.xiaohongshu.ui.message.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venus.xiaohongshu.ui.message.viewmodel.MessageViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/20
 */
@Composable
fun MessageScreen() {
    val vm = viewModel<MessageViewModel>()
    Scaffold(
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
        ) {  
            MessageTopBar()
            
            MessageBody(vm = vm)
        }
    }
}