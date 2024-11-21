package com.venus.xiaohongshu.ui.shop.composable

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.search.SearchActivity

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/19
 */
@Composable
fun ShopTopBar() {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
                .background(colorResource(R.color.theme_background_gray), RoundedCornerShape(12.dp))
                .clickable {
                    context.startActivity(
                        Intent(context.applicationContext, SearchActivity::class.java)
                    )
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = R.drawable.icon_search,
                contentDescription = null,
                modifier = Modifier.size(28.dp)
                    .padding(6.dp)
            )
            Text(
                text = "男生秋冬穿搭",
                color = colorResource(R.color.theme_text_gray),
                fontSize = 12.sp
            )
        }

        AsyncImage(
            model = R.drawable.icon_more_horiz,
            contentDescription = null,
            modifier = Modifier.padding(6.dp)
                .size(20.dp)
        )
    }
}