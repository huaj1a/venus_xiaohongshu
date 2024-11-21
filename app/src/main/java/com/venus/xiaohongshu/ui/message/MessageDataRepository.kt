package com.venus.xiaohongshu.ui.message

import com.venus.xiaohongshu.mock.TitleMock
import com.venus.xiaohongshu.mock.UserMock
import com.venus.xiaohongshu.ui.home.bean.UserBean
import com.venus.xiaohongshu.ui.message.bean.MessageBean
import com.venus.xiaohongshu.ui.message.bean.RecommendFriendBean
import java.util.UUID

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
object MessageDataRepository {
    
    private val messageList = mutableListOf<MessageBean>()

    private val recommendList = mutableListOf<RecommendFriendBean>()
    
    fun getMessageList(): MutableList<MessageBean> {
        if (messageList.isEmpty()) {
            repeat(5) {
                val user = UserBean(
                    id = UUID.randomUUID().toString(),
                    name = UserMock.getRandomName(),
                    image = UserMock.getRandomImage()
                )
                val message = MessageBean(
                    id = UUID.randomUUID().toString(),
                    title = TitleMock.getRandomTitle(),
                    user = user,
                    content = TitleMock.getRandomTitle() + TitleMock.getRandomTitle() + TitleMock.getRandomTitle(),
                    time = "星期五",
                )
                messageList.add(message)
            }
        }
        return messageList
    }

    fun getRecommendList(): MutableList<RecommendFriendBean> {
        if (recommendList.isEmpty()) {
            repeat(20) {
                val user = UserBean(
                    id = UUID.randomUUID().toString(),
                    name = UserMock.getRandomName(),
                    image = UserMock.getRandomImage()
                )
                val recommendFriendBean = RecommendFriendBean(
                    id = UUID.randomUUID().toString(),
                    user = user,
                    reason = TitleMock.getRandomTitle() + TitleMock.getRandomTitle()
                )
                recommendList.add(recommendFriendBean)
            }
        }
        return recommendList
    }
    
}