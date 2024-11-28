package com.venus.xiaohongshu.ui.search

import com.venus.xiaohongshu.mock.TitleMock
import com.venus.xiaohongshu.ui.search.bean.HotspotBean
import java.util.UUID
import kotlin.random.Random

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
object SearchDataRepository {
    
    private val hotspotList = mutableListOf<HotspotBean>()
    
    fun getHotspotList(): MutableList<HotspotBean> {
        hotspotList.clear()
        repeat(20) {
            val hotspotBean = HotspotBean(
                id = UUID.randomUUID().toString(),
                title = TitleMock.getRandomHotspotTitle(),
                heat = Random.nextDouble(100.0, 999.0),
            )
            hotspotList.add(hotspotBean)
        }
        hotspotList.sortByDescending { it.heat }
        return hotspotList
    }
    
}