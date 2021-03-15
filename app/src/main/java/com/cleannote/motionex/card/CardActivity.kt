package com.cleannote.motionex.card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.cleannote.motionex.R
import com.cleannote.motionex.databinding.ActivityCardBinding

class CardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRed.setOnClickListener {
            when (binding.rootMotionView.currentState) {
                R.id.const_spread -> {
                    makeToast("state_spread")
                    transitionRedOnTop()
                }
                R.id.const_red_on_top -> {
                    makeToast("state_red_on_top")
                }
                else -> {}
            }
        }
    }

    private fun makeToast(msg: String){
        Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
    }

    private fun transitionRedOnTop() = with (binding.rootMotionView) {
        setTransition(R.id.const_spread, R.id.const_red_on_top)
        transitionToEnd()
    }


    private fun collapsedCardCompletedListener(@IdRes endStateId: Int) {
        binding.rootMotionView.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.const_red_on_top) {
                    with (binding.rootMotionView) {
                        setTransition(R.id.const_red_on_top, endStateId)
                        transitionToEnd()
                    }
                }
                binding.rootMotionView.setTransitionListener(null)
            }
        })
    }
}