package com.venus.xiaohongshu.ui.home.bean

import com.venus.xiaohongshu.R

/**
 * Description: 图文卡片bean
 *
 * @author: venus
 * @date: 2024/11/15
 */
data class GraphicCardBean(
    val id: String = "",
    val title: String = "",
    val image: Int = R.drawable.icon_logo,
    val user: UserBean,
    val likes: Int = 0
)
