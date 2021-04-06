package com.authencation.designuitavel

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.authencation.designuitavel.databinding.ActivityDisplayPlaceBinding

class DisplayPlace : AppCompatActivity() {
    private val binding: ActivityDisplayPlaceBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fullScreen()
        binding.imageView.setOnClickListener { Intent(this,MainActivity::class.java).also { startActivity(it) } }
        binding.imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_from_left))
        binding.secondTitle.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.anim_from_right
            )
        )
        binding.secondSubtitle.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.anim_from_right
            )
        )
        binding.ratingBar.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_from_left))
        binding.textView2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_from_right))
        binding.textView3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_from_right))
        binding.imageView2.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.anim_from_bottom
            )
        )
        binding.tvMoreDetails.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.anim_from_bottom
            )
        )

        binding.imageView2.setOnClickListener {
            val intent = Intent(this, DetailsPlace::class.java)
            val pairs: Array<Pair<View, String>?> = arrayOfNulls(1)
            pairs[0] = Pair(binding.imageView2, "transition_image")
            val options = ActivityOptions.makeSceneTransitionAnimation(this, *pairs)
            startActivity(intent, options.toBundle())
        }
    }

    private fun fullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowController = window.insetsController
            windowController?.hide(WindowInsets.Type.statusBars())
            windowController?.hide(WindowInsets.Type.navigationBars())
            windowController?.hide(WindowInsets.Type.captionBar())
            windowController?.hide(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE)
        } else
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