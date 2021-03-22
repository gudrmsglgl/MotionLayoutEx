package com.cleannote.motionex.cover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cleannote.motionex.R
import com.cleannote.motionex.cover.flow.FlowDrawableMgr
import com.cleannote.motionex.databinding.ActivityCoverEx3Binding

class CoverEx3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCoverEx3Binding
    private val cardFlowDrawableMgr: FlowDrawableMgr by lazy {
        FlowDrawableMgr(
            this,
            binding.cardFluidTopLeft,
            binding.cardFluidBottomRight
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoverEx3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        cardFlowDrawableMgr.registerFlowAniCallback()
        cardFlowDrawableMgr.startAni()
    }

    override fun onDestroy() {
        super.onDestroy()
        cardFlowDrawableMgr.unregisterFlowAniCallback()
    }
}