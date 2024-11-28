package com.venus.xiaohongshu.ui.home.follow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.home.bean.UserBean

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
@Composable
fun FollowPage() {
    val vm = viewModel<FollowPageViewModel>()
    val recommendUserList = vm.recommendUserList.observeAsState().value
    
    LaunchedEffect(Unit) { 
        vm.load()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) { 
            val (followRefs, titleRefs, loaderRefs) = remember { createRefs() }
            AsyncImage(
                model = R.drawable.icon_love,
                contentDescription = null,
                modifier = Modifier.constrainAs(followRefs) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                    .padding(bottom = 24.dp)
                    .size(68.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .padding(8.dp)
                    .clickable { 
                        if (recommendUserList.isNullOrEmpty()) {
                            vm.load()
                        }
                    }
            )
            
            Column (
                modifier = Modifier.constrainAs(titleRefs) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }.padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "还没有关注的人呢",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "关注后，可以在这里查看对方的最新动态",
                    fontSize = 12.sp,
                    color = colorResource(R.color.theme_text_gray),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            
            if (recommendUserList == null) {
                CardLoader(
                    modifier = Modifier.constrainAs(loaderRefs) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                )
            }
        }
        
        recommendUserList?.forEachIndexed { index, userBean ->
            DraggableCard(
                index = index,
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        top = 16.dp + (index + 2).dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                onSwiped = { _, index ->
                    if (index == 0) {
                        vm.recommendUserList.postValue(null)
                    }
                }
            ) {
                CardContent(userBean)
            }
        }
    }
}

@Composable
fun CardContent(userBean: UserBean) {
    Column { 
        AsyncImage(
            model = userBean.image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) { 
            Text(
                text = userBean.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${userBean.userInfo?.age}  ${if(userBean.userInfo?.sex == 0) "女" else "男"}",
                fontSize = 14.sp,
                color = colorResource(R.color.theme_text_gray),
                modifier = Modifier.padding(top = 6.dp)
            )

            Text(
                text = "${userBean.userInfo?.address}",
                fontSize = 12.sp,
                color = colorResource(R.color.theme_text_gray),
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun CardLoader(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center, 
        modifier = modifier
            .fillMaxSize()
            .clip(CircleShape)
    ) {
        MultiStateAnimationCircleFilledCanvas(color = colorResource(R.color.theme_red), 400f)
        Image(
            painter = painterResource(id = R.drawable.icon_love),
            modifier = modifier
                .size(50.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}
