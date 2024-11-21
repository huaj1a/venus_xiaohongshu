package com.venus.xiaohongshu.ui.mine.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
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
fun MineScrollingTopContent(
    vm: MineViewModel,
    scrollState: ScrollState,
    modifier: Modifier
) {
    val visibilityChangeFloat = scrollState.value > initialImageFloat - 20
    val bgColor = Color(0xFF172C42)
    val gradient = listOf(bgColor, bgColor.copy(alpha = 0.8f), bgColor.copy(alpha = 0.7f), bgColor.copy(alpha = 0.6f))
    Column(
        modifier
            .fillMaxWidth()
            .background(brush = Brush.verticalGradient(colors = gradient))
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    )
    {
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedImage(
                image = vm.user.image,
                scroll = scrollState.value.toFloat()
            )
            Column(
                modifier = Modifier
                    .alpha(animateFloatAsState(if (visibilityChangeFloat) 0f else 1f).value)
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = vm.user.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White
                )
                Text(
                    text = "小红书号: ${vm.user.id.substring(0, 11)}",
                    fontSize = 10.sp,
                    color = Color(0x80FFFFFF)
                )
            }
        }
        Text(
            text = "点击这里，填写简介",
            color = colorResource(R.color.theme_background_gray),
            fontSize = 12.sp,
            letterSpacing = 1.sp
        )
        AsyncImage(
            model = R.drawable.icon_man,
            contentDescription = null,
            modifier = Modifier
                .background(color = Color(0x30FFFFFF),
                    shape = RoundedCornerShape(50)
                )
                .padding(vertical = 1.dp, horizontal = 10.dp)
                .size(20.dp)
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NumberTextView(number = 2, text = "关注")
            NumberTextView(number = 10, text = "粉丝")
            NumberTextView(number = 200, text = "获赞与收藏")
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "编辑资料",
                color = colorResource(R.color.theme_background_gray),
                modifier = Modifier
                    .background(color = Color(0x20FFFFFF), shape = RoundedCornerShape(50))
                    .border(width = 1.dp, color = colorResource(R.color.theme_background_gray), shape = RoundedCornerShape(50))
                    .padding(vertical = 7.dp, horizontal = 16.dp)
            )
            AsyncImage(
                model = R.drawable.icon_setting_white,
                contentDescription = null,
                modifier = Modifier
                    .background(color = Color(0x20FFFFFF), shape = RoundedCornerShape(50))
                    .border(width = 1.dp, color = colorResource(R.color.theme_background_gray), shape = RoundedCornerShape(50))
                    .padding(vertical = 5.dp, horizontal = 16.dp)
                    .size(19.dp)
            )
        }
        
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) { 
            IconTitleTextView(
                icon = R.drawable.icon_shopping_car_white,
                title = "购物车",
                text = "查看推荐好物",
                modifier = Modifier.weight(1f)
            )
            IconTitleTextView(
                icon = R.drawable.icon_leaf_white,
                title = "创作灵感",
                text = "学创作找灵感",
                modifier = Modifier.weight(1f)
            )
            IconTitleTextView(
                icon = R.drawable.icon_clock_white,
                title = "浏览记录",
                text = "看过的笔记",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun IconTitleTextView(
    icon: Int,
    title: String,
    text: String,
    modifier: Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .background(color = Color(0x20FFFFFF), shape = RoundedCornerShape(20))
            .padding(8.dp)
    ) { 
        val (iconRef, titleRef, textRef) = remember { createRefs() }
        
        AsyncImage(
            model = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
                .constrainAs(iconRef) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        
        Text(
            text = title,
            fontSize = 11.sp,
            color = colorResource(R.color.theme_background_gray),
            modifier = Modifier.constrainAs(titleRef){
                start.linkTo(iconRef.end)
                top.linkTo(iconRef.top)
                bottom.linkTo(iconRef.bottom)
            }
                .padding(start = 2.dp)
        )

        Text(
            text = text,
            fontSize = 10.sp,
            color = Color(0x80FFFFFF),
            modifier = Modifier.constrainAs(textRef){
                start.linkTo(parent.start)
                top.linkTo(iconRef.bottom)
            }.padding(top = 2.dp)
        )
    }
}

@Composable
fun NumberTextView(
    number: Int,
    text: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) { 
        Text(
            text = "$number",
            fontSize = 10.sp,
            color = colorResource(R.color.theme_background_gray)
        )
        Text(
            text = text,
            fontSize = 10.sp,
            color = colorResource(R.color.theme_background_gray)
        )
    }
}

@Composable
fun AnimatedImage(
    image: Int,
    scroll: Float
) {
    val dynamicAnimationSizeValue = (initialImageFloat - scroll).coerceIn(36f, initialImageFloat)
    Image(
        painter = painterResource(id = image),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
            .size(animateDpAsState(Dp(dynamicAnimationSizeValue)).value)
            .clip(CircleShape)
    )
}