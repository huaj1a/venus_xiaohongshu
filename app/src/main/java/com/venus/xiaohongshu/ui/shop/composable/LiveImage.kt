package com.venus.xiaohongshu.ui.shop.composable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/20
 */
@Composable
fun LiveImage(
    image: Int
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), 
        label = ""
    )
    val size by infiniteTransition.animateValue(
        initialValue = 50.dp,
        targetValue = 70.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), 
        label = ""
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(6.dp)
            .size(70.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Canvas(
            modifier = Modifier.size(size)
        ) {
            drawCircle(
                color = Color.Red,
                radius = size.toPx() / 2,
                alpha = alpha,
                style = Stroke(width = 1f)
            )
        }
    }
}