package com.venus.xiaohongshu.ui.publish.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.publish.viewmodel.PublishViewModel

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
@Composable
fun AlbumSelectBottomSheet(
    albumSelectList: MutableList<String>,
    vm: PublishViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(color = Color(0xFF363636), RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 0.dp, bottomEnd = 0.dp))
            .animateContentSize()
            .padding(bottom = 16.dp)
    ) {

        LazyRow(
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = albumSelectList) {
                Box(
                    contentAlignment = Alignment.TopEnd
                ) {
                    AsyncImage(
                        model = it,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(56.dp)
                            .clip(RoundedCornerShape(20))
                    )
                    AsyncImage(
                        model = R.drawable.icon_close_white,
                        contentDescription = null,
                        modifier = Modifier.background(color = colorResource(R.color.theme_text_gray), shape = CircleShape)
                            .size(16.dp)
                            .padding(2.dp)
                            .clickable {
                                vm.removeSelect(it)
                            }
                    )
                }

            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "一键成片",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.weight(1f)
                    .background(color = colorResource(R.color.teal_700), shape = RoundedCornerShape(50))
                    .padding(vertical = 14.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "下一步(${albumSelectList.size})",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.weight(1f)
                    .background(color = colorResource(R.color.theme_red), shape = RoundedCornerShape(50))
                    .padding(vertical = 14.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}