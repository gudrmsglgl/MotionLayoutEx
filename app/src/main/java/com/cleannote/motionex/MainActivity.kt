package com.cleannote.motionex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cleannote.motionex.card.CardActivity
import com.cleannote.motionex.cover.CoverActivity
import com.cleannote.motionex.databinding.ActivityMainBinding
import com.cleannote.motionex.swipe.MotionSwipeActivity
import com.cleannote.motionex.toggle.MotionToggleActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCardExam.setOnClickListener {
            Intent(this, CardActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnSwipeExam.setOnClickListener {
            Intent(this, MotionSwipeActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnToggleExam.setOnClickListener {
            Intent(this, MotionToggleActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnCoverExam.setOnClickListener {
            Intent(this, CoverActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}