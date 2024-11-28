package com.venus.xiaohongshu.ui.publish.controller

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log
import com.venus.xiaohongshu.app.TAG

/**
 * Description: 相册管理类
 *
 * @Author: HuaJ1a
 * @Date: 2024/11/27
 */
class AlbumController(context: Context) {
    val albumList = mutableListOf<String>()
    
    init {
        var cursor: Cursor? = null
        try {
            val columns = arrayOf(MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID)
            val orderBy = MediaStore.Images.Media._ID + " desc "
            cursor = context.contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                columns,
                null,
                null,
                orderBy
            )
            cursor?.let {
                while (it.moveToNext()) {
                    val columnIndex = it.getColumnIndex(MediaStore.Images.Media.DATA)
                    val path = "file://" + it.getString(columnIndex)
                    albumList.add(path)
                    Log.i(TAG, path)
                }
            }
        } finally {
            cursor?.close()
        }
        
    }
    
}