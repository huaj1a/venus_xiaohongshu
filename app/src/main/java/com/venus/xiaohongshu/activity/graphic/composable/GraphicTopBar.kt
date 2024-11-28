package com.venus.xiaohongshu.activity.graphic.composable

import android.app.Activity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.activity.graphic.GraphicViewModel
import com.venus.xiaohongshu.ui.common.BackButton

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/28
 */
@Composable
fun GraphicTopBar(vm: GraphicViewModel) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 8.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton {
            (context as Activity).finish()
        }
        AsyncImage(
            model = vm.graphicCardBean?.user?.image,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 10.dp)
                .size(32.dp)
                .clip(CircleShape)
        )
        Text(
            text = vm.graphicCardBean?.user?.name ?: "",
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "关注",
            color = colorResource(R.color.theme_red),
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 8.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.theme_red),
                    shape = RoundedCornerShape(50)
                )
                .padding(vertical = 4.dp, horizontal = 12.dp)
        )
        AsyncImage(
            model = R.drawable.icon_share,
            contentDescription = null,
            modifier = Modifier
                .size(22.dp)
        )
    }
}