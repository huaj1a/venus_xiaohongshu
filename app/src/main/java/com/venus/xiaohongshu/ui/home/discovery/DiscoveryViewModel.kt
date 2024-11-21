package com.venus.xiaohongshu.ui.home.discovery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venus.xiaohongshu.ui.home.HomeDataRepository
import com.venus.xiaohongshu.ui.home.bean.GraphicCardBean
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class DiscoveryViewModel: ViewModel() {
    var graphicCardList = MutableLiveData<MutableList<GraphicCardBean>>()

    fun load() {
        viewModelScope.launch {
            graphicCardList.postValue(HomeDataRepository.getGraphicCardList())
        }
    }
}