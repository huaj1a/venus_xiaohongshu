package com.venus.xiaohongshu.ui.message.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/20
 */
@Composable
fun MessageTopBar() {
    ConstraintLayout(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .fillMaxWidth()
    ) {
        val (titleRef, dicRef) = remember { createRefs() }
        
        Text(
            text = "消息",
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            fontSize = 16.sp
        )
        
        Row(
            modifier = Modifier.constrainAs(dicRef){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }.padding(end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { 
            AsyncImage(
                model = R.drawable.icon_add_friend,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "发现群聊",
                fontSize = 13.sp,
                color = colorResource(R.color.theme_text_gray),
                modifier = Modifier.padding(start = 2.dp)
            )
        }
    }
}