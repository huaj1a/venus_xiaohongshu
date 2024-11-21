package com.venus.xiaohongshu.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
abstract class BaseComposeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply { 
            setContent {
                ComposeContent()
            }
        }
    }
    
    @Composable
    abstract fun ComposeContent()
    
}