package com.venus.xiaohongshu.ui.home.composable

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Description: 骨架加载组件 - 图文卡
 *
 * @author: venus
 * @date: 2024/11/18
 */

val barHeight = 10.dp
val spacerPadding = 3.dp
val roundedCornerShape = RoundedCornerShape(3.dp)
val shimmerColors = listOf(
    Color.LightGray.copy(alpha = 0.6f),
    Color.LightGray.copy(alpha = 0.2f),
    Color.LightGray.copy(alpha = 0.6f),
)

@Composable
fun Shimmer() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        repeat(3) {
            AnimatedShimmerItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedShimmerItem() {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), 
        label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    ShimmerItem(brush = brush)
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerItem(
    brush: Brush = Brush.linearGradient(
        listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )
    )
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 4.dp)
    ) {
        repeat(2) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        start = if (it == 0) 0.dp else 2.dp,
                        end = if (it == 0) 2.dp else 0.dp
                    )
            ) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(roundedCornerShape)
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(spacerPadding))
                Spacer(
                    modifier = Modifier
                        .height(barHeight)
                        .clip(roundedCornerShape)
                        .fillMaxWidth()
                        .background(brush)
                )
                Spacer(modifier = Modifier.padding(spacerPadding))
                Row {
                    Spacer(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(spacerPadding))
                    Spacer(
                        modifier = Modifier
                            .height(barHeight)
                            .width(80.dp)
                            .clip(roundedCornerShape)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Spacer(
                        modifier = Modifier
                            .height(barHeight)
                            .width(40.dp)
                            .clip(roundedCornerShape)
                            .background(brush)
                    )
                    Spacer(modifier = Modifier.padding(spacerPadding))
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ListPreview() {
    Column(Modifier.padding(5.dp)) {
        repeat(3) {
            ShimmerItem()
        }
    }

}