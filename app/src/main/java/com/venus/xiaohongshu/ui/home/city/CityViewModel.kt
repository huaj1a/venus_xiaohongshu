package com.venus.xiaohongshu.ui.home.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venus.xiaohongshu.ui.home.HomeDataRepository
import com.venus.xiaohongshu.ui.home.bean.GraphicCardBean
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class CityViewModel: ViewModel() {
    var cityGraphicCardList = MutableLiveData<MutableList<GraphicCardBean>>()

    fun load() {
        viewModelScope.launch {
            cityGraphicCardList.postValue(HomeDataRepository.getCityGraphicCardList())
        }
    }

    fun reload(): Job {
        return viewModelScope.launch {
            cityGraphicCardList.postValue(HomeDataRepository.getCityGraphicCardList(true))
        }
    }
}