package com.venus.xiaohongshu.ui.shop.bean

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/19
 */
data class GoodsBean(
    val id: String,
    val title: String, // 标题
    val image: Int, // 封面
    val price: Double, // 价格
    val discount: Double, // 折扣
    val times: Int // 购买次数
)
