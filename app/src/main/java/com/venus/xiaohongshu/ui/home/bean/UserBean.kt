package com.venus.xiaohongshu.ui.home.bean

import com.venus.xiaohongshu.R

/**
 * Description: 用户bean
 *
 * @author: venus
 * @date: 2024/11/15
 */
data class UserBean(
    val id: String,
    val name: String = "",
    val image: Int = R.drawable.icon_mine
)