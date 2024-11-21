package com.venus.xiaohongshu.ui.mine

import com.venus.xiaohongshu.mock.ImageMock
import com.venus.xiaohongshu.mock.TitleMock
import com.venus.xiaohongshu.mock.UserMock
import com.venus.xiaohongshu.ui.home.bean.GraphicCardBean
import com.venus.xiaohongshu.ui.home.bean.UserBean
import kotlinx.coroutines.delay
import java.util.UUID
import kotlin.random.Random

/**
 * Description: home 数据仓库，代替网络请求
 *
 * @author: venus
 * @date: 2024/11/15
 */
object MineDataRepository {
    
    // 发现图文卡
    private val graphicCardList = mutableListOf<GraphicCardBean>()
    
    suspend fun getGraphicCardList(): MutableList<GraphicCardBean> {
        if (graphicCardList.isEmpty()) {
            repeat(50) {
                val user = UserBean(
                    id = UUID.randomUUID().toString(),
                    name = UserMock.getRandomName(),
                    image = UserMock.getRandomImage()
                )
                val graphicCardBean = GraphicCardBean(
                    id = UUID.randomUUID().toString(),
                    title = TitleMock.getRandomTitle(),
                    user = user,
                    image = ImageMock.getRandomImage(),
                    likes = Random.nextInt(999)
                )
                graphicCardList.add(graphicCardBean)
                delay(1)
            }
        }
        return graphicCardList
    }
}