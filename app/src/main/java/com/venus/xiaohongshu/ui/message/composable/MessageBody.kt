package com.venus.xiaohongshu.ui.message.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.message.viewmodel.MessageViewModel

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
@Composable
fun MessageBody(
    vm: MessageViewModel
) {
    val messageList = vm.messageList.observeAsState().value
    val recommendList = vm.recommendList.observeAsState().value
    val recommendFlag = remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        vm.load()
    }
    
    Box(
        modifier = Modifier.fillMaxSize()
    ) { 
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) { 
            item {
                BodyTopCard()
            }

            messageList?.let { messageList ->
                itemsIndexed(items = messageList) { _, item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {  }
                    ) { 
                        AsyncImage(
                            model = item.user.image,
                            contentDescription = null,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                                .size(56.dp)
                                .clip(CircleShape)
                        )
                        
                        Column(
                            modifier = Modifier.weight(1f)
                        ) { 
                            Text(
                                text = item.title,
                                fontSize = 12.sp
                            )

                            Text(
                                text = item.content,
                                fontSize = 11.sp,
                                color = colorResource(R.color.theme_text_gray),
                                modifier = Modifier.padding(top = 4.dp),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        
                        Text(
                            text = item.time,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontSize = 10.sp,
                            color = colorResource(R.color.theme_text_gray),
                        )
                    }
                }
            }
            
            if (recommendFlag.value) {
                item {
                    RecommendControlCard(recommendFlag = recommendFlag)
                }
                recommendList?.let { recommendList ->
                    itemsIndexed(items = recommendList) { _, item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable {  }
                        ) {
                            AsyncImage(
                                model = item.user.image,
                                contentDescription = null,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                                    .size(56.dp)
                                    .clip(CircleShape)
                            )

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = item.user.name,
                                    fontSize = 12.sp
                                )

                                Text(
                                    text = item.reason,
                                    fontSize = 11.sp,
                                    color = colorResource(R.color.theme_text_gray),
                                    modifier = Modifier.padding(top = 4.dp),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                            
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
                                model = R.drawable.icon_close,
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                                    .padding(end = 16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendControlCard(
    recommendFlag: MutableState<Boolean>
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "发现更多好友",
            fontSize = 14.sp
        )
        AsyncImage(
            model = R.drawable.icon_alert,
            contentDescription = null,
            modifier = Modifier.size(12.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "关闭",
            fontSize = 14.sp,
            color = colorResource(R.color.theme_text_gray),
            modifier = Modifier.clickable {
                recommendFlag.value = false
            }
        )
    }
}

@Composable
fun BodyTopCard() {
    Row(
        modifier = Modifier.padding(vertical = 26.dp, horizontal = 16.dp)
    ) {
        IconTextView(
            icon = R.drawable.icon_love,
            iconBackground = Color(0x60FA8072),
            text = "赞和收藏",
            modifier = Modifier.weight(1f)
        )
        IconTextView(
            icon = R.drawable.icon_person,
            iconBackground = Color(0x601E90FF),
            text = "新增关注",
            modifier = Modifier.weight(1f)
        )
        IconTextView(
            icon = R.drawable.icon_pinglun_1,
            iconBackground = Color(0x6000EE76),
            text = "评论和@",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun IconTextView(
    icon: Int,
    iconBackground: Color,
    text: String,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) { 
        AsyncImage(
            model = icon,
            contentDescription = null,
            modifier = Modifier.size(48.dp)
                .background(
                    color = iconBackground,
                    shape = RoundedCornerShape(26)
                )
                .padding(8.dp)
        )
        
        Text(
            text = text,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}