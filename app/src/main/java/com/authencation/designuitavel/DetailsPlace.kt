package com.authencation.designuitavel

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.viewbinding.library.activity.viewBinding
import com.authencation.designuitavel.databinding.ActivityDetailsPlaceBinding
import com.authencation.designuitavel.databinding.ActivityDisplayPlaceBinding

class DetailsPlace : AppCompatActivity() {
    private val binding:ActivityDetailsPlaceBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fullScreen()
        binding.imageDown.setOnClickListener {
            val intent = Intent(this, DisplayPlace::class.java)
            val pairs:Array<Pair<View, String>?> = arrayOfNulls(1)
            pairs[0] = Pair(binding.imageDown,"transition_image")
            val options = ActivityOptions.makeSceneTransitionAnimation(this, *pairs)
            startActivity(intent,options.toBundle())
        }
        binding.scrollView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom))
        binding.imageDown.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom))
    }

    private fun fullScreen(){
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.R){
            val windowController = window.insetsController
            windowController?.hide(WindowInsets.Type.statusBars())
            windowController?.hide(WindowInsets.Type.navigationBars())
            windowController?.hide(WindowInsets.Type.captionBar())
            windowController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        }else
            window.decorView.apply {
                systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            }
    }
}