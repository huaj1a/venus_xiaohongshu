package com.venus.xiaohongshu.ui.mine.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.mine.viewmodel.MineViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
@Composable
fun MineTopBar(
    vm: MineViewModel,
    modifier: Modifier,
    scroll: Float
) {
    Box(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = R.drawable.icon_menu_white,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                model = R.drawable.icon_scan_white,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(24.dp)
            )

            AsyncImage(
                model = R.drawable.icon_share_white,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        if (scroll > initialImageFloat + 200) {
            AsyncImage(
                model = vm.user.image,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
        }
    }

}