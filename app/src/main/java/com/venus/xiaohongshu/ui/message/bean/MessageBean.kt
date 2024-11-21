package com.venus.xiaohongshu.ui.message.bean

import com.venus.xiaohongshu.ui.home.bean.UserBean

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
data class MessageBean(
    val id: String,
    val user: UserBean,
    val title: String,
    val content: String,
    val time: String,
    val new: Boolean = false, // 新消息提醒
)
