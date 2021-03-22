package com.cleannote.motionex.cover.flow

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.cleannote.motionex.R

class FlowDrawableMgr(
    private val context: Context,
    private val ivTop: ImageView,
    private val ivBottom: ImageView
) {

    private val drawAniTopLeftForward = AnimatedVectorDrawableCompat.create(
        context, R.drawable.top_left_liquid_forward
    )
    private val drawAniTopLeftAniReverse = AnimatedVectorDrawableCompat.create(
        context, R.drawable.top_left_liquid_reverse
    )
    private val topLeftAniForwardCallback = TopLeftForwardCallback(ivTop, drawAniTopLeftAniReverse)
    private val topLeftAniReverseCallback = TopLeftReverseCallback(ivTop, drawAniTopLeftForward)

    private val drawAniBottomRightForward = AnimatedVectorDrawableCompat.create(
        context, R.drawable.bottom_right_liquid_forward
    )
    private val drawAniBottomRightReverse = AnimatedVectorDrawableCompat.create(
        context, R.drawable.bottom_right_liquid_reverse
    )
    private val bottomRightForwardCallback = BottomRightForwardCallback(ivBottom, drawAniBottomRightReverse)
    private val bottomRightReverseCallback = BottomRightReverseCallback(ivBottom, drawAniBottomRightForward)

    fun startAni(){
        ivTop.setImageDrawable(drawAniTopLeftForward)
        ivBottom.setImageDrawable(drawAniBottomRightForward)
        drawAniTopLeftForward?.start()
        drawAniBottomRightForward?.start()
    }

    fun registerFlowAniCallback(){
        drawAniTopLeftForward?.registerAnimationCallback(topLeftAniForwardCallback)
        drawAniTopLeftAniReverse?.registerAnimationCallback(topLeftAniReverseCallback)
        drawAniBottomRightForward?.registerAnimationCallback(bottomRightForwardCallback)
        drawAniBottomRightReverse?.registerAnimationCallback(bottomRightReverseCallback)
    }

    fun unregisterFlowAniCallback(){
        drawAniTopLeftForward?.unregisterAnimationCallback(topLeftAniForwardCallback)
        drawAniTopLeftAniReverse?.unregisterAnimationCallback(topLeftAniReverseCallback)
        drawAniBottomRightForward?.unregisterAnimationCallback(bottomRightForwardCallback)
        drawAniBottomRightReverse?.unregisterAnimationCallback(bottomRightReverseCallback)
    }

    class TopLeftForwardCallback(
        private val ivTop: ImageView,
        private val topLeftAniReverse: AnimatedVectorDrawableCompat?) : Animatable2Compat.AnimationCallback()
    {
        override fun onAnimationEnd(drawable: Drawable?) {
            ivTop.setImageDrawable(topLeftAniReverse)
            topLeftAniReverse?.start()
        }
    }

    class TopLeftReverseCallback(
        private val ivTop: ImageView,
        private val topLeftAniForward: AnimatedVectorDrawableCompat?) : Animatable2Compat.AnimationCallback()
    {
        override fun onAnimationEnd(drawable: Drawable?) {
            ivTop.setImageDrawable(topLeftAniForward)
            topLeftAniForward?.start()
        }
    }

    class BottomRightForwardCallback(
        private val ivBottom: ImageView,
        private val drawAniBottomReverse: AnimatedVectorDrawableCompat?) : Animatable2Compat.AnimationCallback()
    {
        override fun onAnimationEnd(drawable: Drawable?) {
            ivBottom.setImageDrawable(drawAniBottomReverse)
            drawAniBottomReverse?.start()
        }
    }

    class BottomRightReverseCallback(
        private val ivBottom: ImageView,
        private val drawAniBottomForward: AnimatedVectorDrawableCompat?) : Animatable2Compat.AnimationCallback()
    {
        override fun onAnimationEnd(drawable: Drawable?) {
            ivBottom.setImageDrawable(drawAniBottomForward)
            drawAniBottomForward?.start()
        }
    }

}