package com.authencation.designuitavel

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.viewbinding.library.activity.viewBinding
import com.authencation.designuitavel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fullScreen()

        binding.cardViewOne.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom))
        binding.cardViewSecond.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom))
        binding.cardViewThree.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom))

        binding.firstText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_top))
        binding.secondText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_top))
        binding.thirdText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_top))
        binding.fourText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_top))
        binding.fiveText.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_top))
        binding.imageSettings.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_top))

        binding.searchView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_from_left))

        binding.cardViewOne.setOnClickListener {
            Intent(this,DisplayPlace::class.java).also { startActivity(it) }
        }


    }


    private fun fullScreen(){
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
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