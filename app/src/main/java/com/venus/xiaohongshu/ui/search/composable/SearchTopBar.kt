package com.venus.xiaohongshu.ui.search.composable

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.common.BackButton

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
@Composable
fun SearchTopBar() {
    val context = LocalContext.current
    var inputText by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton {
            (context as Activity).finish()
        }

        BasicTextField(
            modifier = Modifier
                .background(colorResource(R.color.theme_background_gray), RoundedCornerShape(50))
                .weight(1f)
                .height(30.dp),
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
                    AsyncImage(
                        model = R.drawable.icon_search,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 5.dp)
                            .size(24.dp)
                    )
                    Box(
                        modifier = Modifier.padding(start = 5.dp)
                    ) {
                        if(inputText.text.isEmpty()) {
                            Text(
                                text = "珠海航展",
                                color = colorResource(R.color.theme_text_gray)
                            )
                        }
                        innerTextField()
                    }
                }
            }
        )

        Text(
            text = "搜索",
            color = colorResource(R.color.theme_text_gray),
            modifier = Modifier.padding(start = 12.dp)
                .clickable {  }
        )
    }
}