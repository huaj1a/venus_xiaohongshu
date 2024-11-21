package com.venus.xiaohongshu.ui.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/18
 */
@Composable
@Preview
fun HomeDrawer() {
    Scaffold(
        modifier = Modifier.width(300.dp),
        containerColor = colorResource(R.color.theme_background_gray)
    ) {  innerPadding ->
        Column(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding(), start = 8.dp)
        ) {
            Column(
                modifier = Modifier.width(250.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
            ) { 
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_add_friend,
                    text = "发现好友"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.width(250.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
            ) {
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_person_edit,
                    text = "创作者中心"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.width(250.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
            ) {
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_caogao,
                    text = "我的草稿"
                )
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_pinglun,
                    text = "我的评论"
                )
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_clock,
                    text = "浏览记录"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.width(250.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
            ) {
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_order,
                    text = "订单"
                )
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_shopping_car,
                    text = "购物车"
                )
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_wallet,
                    text = "钱包"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.width(250.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
            ) {
                HorizontalIconTextWidget(
                    icon = R.drawable.icon_leaf,
                    text = "社区公约"
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.width(250.dp)
            ) {
                VerticalIconTextWidget(
                    icon = R.drawable.icon_scan,
                    text = "扫一扫",
                    modifier = Modifier.weight(1f)
                )

                VerticalIconTextWidget(
                    icon = R.drawable.icon_scan,
                    text = "帮助与客服",
                    modifier = Modifier.weight(1f)
                )

                VerticalIconTextWidget(
                    icon = R.drawable.icon_setting,
                    text = "设置",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun HorizontalIconTextWidget(
    icon: Int,
    text: String
) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun VerticalIconTextWidget(
    icon: Int,
    text: String,
    modifier: Modifier
) {
    Column (
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            fontSize = 10.sp
            
        )
    }
}