package com.cleannote.motionex.cover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cleannote.motionex.R
import com.cleannote.motionex.databinding.ActivityCoverBinding

class CoverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCoverEx1.setOnClickListener {
            Intent(this, CoverEx1Activity::class.java).also {
                startActivity(it)
            }
        }
    }
}