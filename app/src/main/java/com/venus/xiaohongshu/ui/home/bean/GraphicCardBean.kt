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
    val video: Int = 0,
    val user: UserBean,
    val likes: Int = 0,
    val type: GraphicCardType = GraphicCardType.Graphic
)

enum class GraphicCardType() {
    Graphic, // 图文类型
    Video, // 视频类型
}
