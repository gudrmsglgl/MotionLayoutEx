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
                    transitionSpreadToCollapse()
                }
                R.id.const_red_on_top -> {
                    makeToast("state_red_on_top")
                }
                R.id.const_purple_on_top -> {
                    transitionPurpleToRed()
                }
                R.id.const_black_on_top -> {
                    transitionBlackToRed()
                }
            }
        }

        binding.btnPurple.setOnClickListener {
            when (binding.rootMotionView.currentState) {
                R.id.const_spread -> {
                    transitionSpreadToCollapse()
                    transitionCollapseTo(endStateId = R.id.const_purple_on_top)
                }
                R.id.const_purple_on_top -> {
                    makeToast("state_purple_on_top")
                }
                R.id.const_red_on_top -> {
                    transitionPurpleOnTop()
                }
                R.id.const_black_on_top -> {
                    transitionBlackToPurple()
                }
            }
        }

        binding.btnBlack.setOnClickListener {
            when (binding.rootMotionView.currentState) {
                R.id.const_spread -> {
                    transitionSpreadToCollapse()
                    transitionCollapseTo(endStateId = R.id.const_black_on_top)
                }
                R.id.const_black_on_top -> {
                    makeToast("state_black_on_top")
                }
                R.id.const_red_on_top -> {
                    transitionBlackOnTop()
                }
                R.id.const_purple_on_top -> {
                    transitionPurpleToBlack()
                }
            }
        }
    }

    private fun makeToast(msg: String){
        Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
    }

    private fun transitionSpreadToCollapse() = with (binding.rootMotionView) {
        setTransition(R.id.transition_spread_to_collapse)
        transitionToEnd()
    }

    private fun transitionPurpleToRed() = with (binding.rootMotionView) {
        setTransition(R.id.transition_purple_to_red)
        transitionToEnd()
    }

    private fun transitionBlackToRed() = with (binding.rootMotionView) {
        setTransition(R.id.transition_black_to_red)
        transitionToEnd()
    }

    private fun transitionBlackToPurple() = with (binding.rootMotionView) {
        setTransition(R.id.transition_black_to_purple)
        transitionToEnd()
    }

    private fun transitionPurpleOnTop() = with (binding.rootMotionView) {
        setTransition(R.id.transition_purple_on_top)
        transitionToEnd()
    }

    private fun transitionPurpleToBlack() = with (binding.rootMotionView) {
        setTransition(R.id.transition_purple_to_black)
        transitionToEnd()
    }

    private fun transitionBlackOnTop() = with (binding.rootMotionView) {
        setTransition(R.id.transition_black_on_top)
        transitionToEnd()
    }

    private fun transitionCollapseTo(@IdRes endStateId: Int) {
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