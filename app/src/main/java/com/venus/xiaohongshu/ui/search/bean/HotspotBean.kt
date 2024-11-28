package com.venus.xiaohongshu.ui.search.bean

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
data class HotspotBean(
    val id: String,
    val title: String,
    val heat: Double, // 热度
    val label: String = "", // 标签
)
