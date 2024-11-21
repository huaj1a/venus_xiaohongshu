package com.venus.xiaohongshu.mock

import com.venus.xiaohongshu.R
import kotlin.random.Random

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/18
 */
object ImageMock {
    private val imageList = listOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4,
        R.drawable.image_5,
        R.drawable.image_6,
        R.drawable.image_7,
        R.drawable.image_8,
        R.drawable.image_9,
        R.drawable.image_10,
        R.drawable.image_11,
        R.drawable.image_12,
        R.drawable.image_13,
    )
    
    private val goodsList = listOf(
        R.drawable.goods_1,
        R.drawable.goods_2,
        R.drawable.goods_3,
        R.drawable.goods_4,
        R.drawable.goods_5,
        R.drawable.goods_6,
        R.drawable.goods_7,
        R.drawable.goods_8,
        R.drawable.goods_9,
        R.drawable.goods_10,
        R.drawable.goods_11,
        R.drawable.goods_12,
        R.drawable.goods_13,
        R.drawable.goods_14,
        R.drawable.goods_15,
        R.drawable.goods_16,
        R.drawable.goods_17,
        R.drawable.goods_18,
        R.drawable.goods_19,
        R.drawable.goods_20,
    )
    
    fun getRandomImage(): Int {
        return imageList[Random.nextInt(imageList.size)]
    }
    
    fun getRandomGoods(): Int {
        return goodsList[Random.nextInt(goodsList.size)]
    }
}