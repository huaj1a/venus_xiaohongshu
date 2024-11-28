package com.venus.xiaohongshu.ui.home

import com.venus.xiaohongshu.mock.ImageMock
import com.venus.xiaohongshu.mock.TitleMock
import com.venus.xiaohongshu.mock.UserMock
import com.venus.xiaohongshu.mock.VideoMock
import com.venus.xiaohongshu.ui.home.bean.GraphicCardBean
import com.venus.xiaohongshu.ui.home.bean.GraphicCardType
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
object HomeDataRepository {
    
    // 发现图文卡
    private val graphicCardList = mutableListOf<GraphicCardBean>()
    // 同城图文卡
    private val cityGraphicCardList = mutableListOf<GraphicCardBean>()
    
    suspend fun getGraphicCardList(reload: Boolean = false): MutableList<GraphicCardBean> {
        if (graphicCardList.isEmpty() || reload) {
            val tempList = mutableListOf<GraphicCardBean>()
            repeat(200) {
                val user = UserBean(
                    id = UUID.randomUUID().toString(),
                    name = UserMock.getRandomName(),
                    image = UserMock.getRandomImage()
                )
                val type = if(Random.nextDouble() < 0.2) GraphicCardType.Video else GraphicCardType.Graphic
                val video = if (type == GraphicCardType.Video) VideoMock.getRandomVideo() else 0
                val graphicCardBean = GraphicCardBean(
                    id = UUID.randomUUID().toString(),
                    title = TitleMock.getRandomTitle(),
                    user = user,
                    image = ImageMock.getRandomImage(),
                    video = video,
                    likes = Random.nextInt(999),
                    type = type
                )
                tempList.add(graphicCardBean)
                delay(3)
            }
            graphicCardList.clear()
            graphicCardList.addAll(tempList)
        }
        return graphicCardList
    }

    suspend fun getCityGraphicCardList(reload: Boolean = false): MutableList<GraphicCardBean> {
        if (cityGraphicCardList.isEmpty() || reload) {
            val tempList = mutableListOf<GraphicCardBean>()
            repeat(200) {
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
                tempList.add(graphicCardBean)
                delay(5)
            }
            cityGraphicCardList.clear()
            cityGraphicCardList.addAll(tempList)
        }
        return cityGraphicCardList
    }

    suspend fun getRecommendUserList(): MutableList<UserBean> {
        val recommendUserList = mutableListOf<UserBean>()
        repeat(10) {
            val user = UserBean(
                id = UUID.randomUUID().toString(),
                name = UserMock.getRandomName(),
                image = UserMock.getRandomImage(),
                userInfo = UserMock.gerRandomUserInfo()
            )
            recommendUserList.add(user)
            delay(50)
        }
        return recommendUserList
    }
    
}