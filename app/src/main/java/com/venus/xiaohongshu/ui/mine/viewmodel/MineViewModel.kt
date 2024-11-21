package com.venus.xiaohongshu.ui.mine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venus.xiaohongshu.mock.UserMock
import com.venus.xiaohongshu.ui.home.HomeDataRepository
import com.venus.xiaohongshu.ui.home.bean.GraphicCardBean
import com.venus.xiaohongshu.ui.home.bean.UserBean
import kotlinx.coroutines.launch
import java.util.UUID

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/21
 */
class MineViewModel: ViewModel() {
    
    val user = UserBean(
        id = UUID.randomUUID().toString(),
        name = UserMock.getRandomName(),
        image = UserMock.getRandomImage()
    )

    var graphicCardList = MutableLiveData<MutableList<GraphicCardBean>>()

    fun load() {
        viewModelScope.launch {
            graphicCardList.postValue(HomeDataRepository.getGraphicCardList())
        }
    }
    
}