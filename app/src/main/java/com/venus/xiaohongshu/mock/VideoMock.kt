package com.venus.xiaohongshu.mock

import com.venus.xiaohongshu.R
import kotlin.random.Random

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/22
 */
object VideoMock {
    
    private val videoList = listOf(
        R.raw.video_1,
        R.raw.video_2,
        R.raw.video_3
    )
    
    fun getRandomVideo(): Int {
        return videoList[Random.nextInt(videoList.size)]
    }
    
}