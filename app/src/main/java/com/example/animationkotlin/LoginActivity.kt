package com.example.animationkotlin

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animationkotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        playAnimation()

    }
    private fun playAnimation() {
        Log.d("LoginActivity", "playAnimation called")
            ObjectAnimator.ofFloat(binding.imageView2, View.TRANSLATION_X, -30f, 30f).apply {
                duration = 3000
                repeatCount = ObjectAnimator.INFINITE
                repeatMode = ObjectAnimator.REVERSE
            }.start()
        Log.d("LoginActivity", "Animation started")

        val text = ObjectAnimator.ofFloat(binding.textView2, View.ALPHA, 0f, 1f).setDuration(3000)
        val button = ObjectAnimator.ofFloat(binding.button2, View.ALPHA, 0f, 1f).setDuration(3000)

       AnimatorSet().apply {
           playTogether(text,button)
           start()
           Log.e(TAG, "Animation started 2")
        }

    }

    companion object{
        private const val TAG = "Login Activity"
    }
}