package com.venus.xiaohongshu.activity.graphic.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.activity.graphic.GraphicViewModel
import com.venus.xiaohongshu.ui.common.Divider
import kotlin.random.Random

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/28
 */
@Composable
fun GraphicBody(vm: GraphicViewModel, modifier: Modifier) {
    var inputText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    LazyColumn(
        modifier = modifier
    ) {
        item{
            AsyncImage(
                model = vm.graphicCardBean?.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .background(Color.Black),
                contentScale = ContentScale.Fit
            )
        }

        // 文案
        item {
            Text(
                text = vm.graphicCardBean?.title ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Start
            )
            Text(
                text = "编辑与 今天 ${Random.nextInt(0,25)}:${Random.nextInt(0,60)} 广东",
                fontSize = 12.sp,
                color = colorResource(R.color.theme_text_gray),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        item {
            Column (
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            ) {
                Divider()
                Text(
                    text = "共${Random.nextInt(0,1000)}条评论",
                    fontSize = 12.sp,
                    color = colorResource(R.color.theme_text_gray),
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    AsyncImage(
                        model = R.drawable.icon_cake,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp)
                    )
                    BasicTextField(
                        modifier = Modifier
                            .background(colorResource(R.color.theme_background_gray), RoundedCornerShape(50))
                            .weight(1f)
                            .height(35.dp),
                        value = inputText,
                        onValueChange = {
                            inputText = it
                        },
                        cursorBrush = SolidColor(colorResource(R.color.theme_red)),
                        decorationBox = { innerTextField ->
                            Row (
                                modifier = Modifier.fillMaxSize()
                                    .padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 10.dp)
                                ) {
                                    if(inputText.text.isEmpty()) {
                                        Text(
                                            text = "爱评论的人运气都不差",
                                            color = colorResource(R.color.theme_text_gray),
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                    innerTextField()
                                }
                                AsyncImage(
                                    model = R.drawable.icon_aite,
                                    contentDescription = null,
                                    modifier = Modifier.padding(start = 10.dp)
                                        .size(20.dp)
                                )
                                AsyncImage(
                                    model = R.drawable.icon_smile,
                                    contentDescription = null,
                                    modifier = Modifier.padding(start = 10.dp)
                                        .size(20.dp)
                                )
                                AsyncImage(
                                    model = R.drawable.icon_picture,
                                    contentDescription = null,
                                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                                        .size(20.dp)
                                )
                            }
                        }
                    )
                }
            }
        }

        // 评论
        items(items = vm.commentList) {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                AsyncImage(
                    model = it.user.image,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(26.dp)
                        .clip(CircleShape)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = it.user.name,
                        color = colorResource(R.color.theme_text_gray)
                    )
                    Text(
                        text = it.title
                    )
                    Text(
                        text = "昨天${Random.nextInt(0, 25)}:${Random.nextInt(0, 60)} 广东 回复",
                        fontSize = 12.sp,
                        color = colorResource(R.color.theme_text_gray)
                    )
                }

                Column {
                    AsyncImage(
                        model = R.drawable.icon_favorite,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .size(24.dp)
                    )
                    Text(
                        text = "${it.likes}",
                        color = colorResource(R.color.theme_text_gray),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}