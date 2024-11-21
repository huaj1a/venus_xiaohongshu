package com.venus.xiaohongshu

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.view.MotionEvent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.venus.xiaohongshu.databinding.ActivityMainBinding
import com.venus.xiaohongshu.ui.publish.PublishActivity

/**
 * Description:
 *
 * @author: venus
 * @date: 2024/11/15
 */
class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding
    
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        NavigationUI.setupWithNavController(binding.navView, navController)
        val menu = binding.navView.menu
        for (i in 0 until menu.size()) {
            val item = menu.getItem(i)
            if (item.itemId == R.id.navigation_publish) {
                item.icon?.let {
                    it.setBounds(0, 0, 128, 128)
                    val spannableString = SpannableString(" ")
                    val imageSpan = ImageSpan(it, ImageSpan.ALIGN_BASELINE)
                    spannableString.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                    item.setIcon(null)
                    item.setTitle(spannableString)
                }
            }
        }
        binding.navView.setItemOnTouchListener(R.id.navigation_publish
        ) { _, event ->
            when (event?.action) {
                MotionEvent.ACTION_UP -> {
                    val intent = Intent(baseContext, PublishActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }
}