package com.venus.xiaohongshu.ui.shop.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venus.xiaohongshu.ui.shop.viewmodel.ShopViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/18
 */
@Preview
@Composable
fun ShopScreen() {
    val vm = viewModel<ShopViewModel>()
    LaunchedEffect(Unit) { 
        vm.load()
    }
    Scaffold(
        containerColor = Color.White
    ) {  innerPadding ->
        Column(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
        ) { 
            ShopTopBar()
            
            ShopBody(vm = vm)
        }
    }
}