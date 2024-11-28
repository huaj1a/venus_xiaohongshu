package com.venus.xiaohongshu.activity.graphic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.venus.xiaohongshu.activity.graphic.composable.GraphicScreen
import com.venus.xiaohongshu.base.BaseComposeActivity

/**
 * Description: 图文activity
 *
 * @author: venus
 * @date: 2024/11/22
 */
const val KEY_ID = "key_id"
class GraphicActivity: BaseComposeActivity() {
    
    private val vm: GraphicViewModel by viewModels<GraphicViewModel>()
    
    companion object {
        fun newInstance(context: Context, id: String) {
            val intent = Intent(context, GraphicActivity::class.java)
            intent.putExtra(KEY_ID, id);
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.id = intent.getStringExtra(KEY_ID) ?: ""
        vm.init()
    }
    
    @Composable
    override fun ComposeContent() {
        GraphicScreen()
    }
    
}