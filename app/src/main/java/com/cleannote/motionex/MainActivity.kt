package com.cleannote.motionex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cleannote.motionex.card.CardActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_card_exam).setOnClickListener {
            Intent(this, CardActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}