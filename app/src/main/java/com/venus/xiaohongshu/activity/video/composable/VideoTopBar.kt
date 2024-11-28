package com.venus.xiaohongshu.activity.video.composable

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.search.SearchActivity

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/28
 */
@Composable
fun VideoTopBar() {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = R.drawable.icon_return_white,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
                .clickable {
                    (context as Activity).finish()
                }
        )
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = R.drawable.icon_search_white,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    context.startActivity(Intent(context, SearchActivity::class.java))
                }
        )
        AsyncImage(
            model = R.drawable.icon_share_white,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
        )
    }
}