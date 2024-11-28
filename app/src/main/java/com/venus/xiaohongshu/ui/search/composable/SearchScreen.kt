package com.venus.xiaohongshu.ui.search.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.common.Divider
import com.venus.xiaohongshu.ui.search.bean.HotspotBean
import com.venus.xiaohongshu.ui.search.viewmodel.SearchViewModel

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
@Preview
@Composable
fun SearchScreen() {
    val vm = viewModel<SearchViewModel>()
    val hotspotList = vm.hotspotList.observeAsState().value
    
    LaunchedEffect(Unit) {
        vm.load();
    }
    Scaffold(
        containerColor = Color.White
    ) {  innerPadding -> 
        Column(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp
            )
        ) {
            SearchTopBar()
            
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 16.dp)
            ) { 
                // 历史记录
                item {
                    SearchHistoryCard()
                }
                
                // 猜你想搜
                item {
                    SearchGuessCard()
                }
                
                //热点title
                item{
                    SearchHotTitleCard()
                }

                hotspotList?.let { 
                    itemsIndexed(items = hotspotList) { index, item ->
                        SearchHotspotItem(index, item)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchHotspotItem(index: Int,hotspotBean: HotspotBean) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) { 
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { 
            Text(
                text = "${index + 1}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if(index == 0) colorResource(R.color.theme_red) 
                else if(index == 1) Color(0xFFFF8C00)
                else if(index == 2) Color(0xFFFF8C00)
                else colorResource(R.color.theme_text_gray),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = hotspotBean.title,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${"%.1f".format(hotspotBean.heat)}万",
                color = colorResource(R.color.theme_text_gray)
            )
        }
        Divider()
    }
}


