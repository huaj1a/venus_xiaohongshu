package com.venus.xiaohongshu.ui.search.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchHistoryCard() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "历史记录",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                model = R.drawable.icon_lajitong,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }

        FlowRow(modifier = Modifier.padding(top = 6.dp)) {
            HistoryItem("Android compose")
            HistoryItem("PHP是不是最厉害的语言")
            HistoryItem("C语言脱发攻略")
            HistoryItem("C++从入门到入狱")
            HistoryItem("Android逆向怎么把别人钱包的钱转到自己这里")
            HistoryItem("血迹怎么可以清除干净")
        }
    }
}

@Composable
fun HistoryItem(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 6.dp, end = 10.dp)
            .height(28.dp)
            .border(
                width = 1.dp,
                color = colorResource(R.color.theme_background_gray),
                RoundedCornerShape(50)
            )
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Text(
            text = text
        )
    }
}