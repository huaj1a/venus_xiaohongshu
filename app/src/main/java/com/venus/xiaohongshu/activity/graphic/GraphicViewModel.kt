package com.venus.xiaohongshu.activity.graphic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venus.xiaohongshu.ui.home.HomeDataRepository
import com.venus.xiaohongshu.ui.home.bean.GraphicCardBean
import kotlinx.coroutines.launch

/**
 * Description:
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/28
 */
class GraphicViewModel: ViewModel() {
    
    var id: String = ""
    var graphicCardBean: GraphicCardBean? = null
    var commentList = mutableListOf<GraphicCardBean>()
    
    fun init() {
        if (id.isEmpty()) {
            return
        }
        viewModelScope.launch { 
            HomeDataRepository.getGraphicCardList().forEach { 
                if (it.id == id) {
                    graphicCardBean = it
                }
            }
            commentList = HomeDataRepository.getGraphicCardList().subList(0, 30)
        }
    }
    
}