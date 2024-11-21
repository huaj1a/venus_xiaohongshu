package com.venus.xiaohongshu.ui.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venus.xiaohongshu.R
import com.venus.xiaohongshu.ui.shop.ShopDataRepository
import com.venus.xiaohongshu.ui.shop.bean.GoodsBean
import com.venus.xiaohongshu.ui.shop.bean.MenuBean
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/19
 */
class ShopViewModel: ViewModel() {
    
    val menuList = listOf(
        MenuBean(R.drawable.icon_order, "我的订单"),
        MenuBean(R.drawable.icon_shopping_car, "购物车"),
        MenuBean(R.drawable.icon_pinglun, "客服消息"),
        MenuBean(R.drawable.icon_kaquan, "卡券"),
        MenuBean(R.drawable.icon_clock, "浏览记录"),
        MenuBean(R.drawable.icon_dianpu, "关注店铺"),
        MenuBean(R.drawable.icon_xinyuan, "心愿单")
    )
    
    val goodsList = MutableLiveData<MutableList<GoodsBean>>()
    
    fun load() {
        viewModelScope.launch { 
            goodsList.postValue(ShopDataRepository.getGoodsList())
        }
    }
    
}