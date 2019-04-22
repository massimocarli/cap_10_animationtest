package uk.co.massimocarli.animationtest.util

import android.animation.Animator
import android.animation.TimeInterpolator
import android.view.animation.Interpolator

fun TimeInterpolator.reverse(): TimeInterpolator {
  return object : Interpolator {
    override fun getInterpolation(input: Float): Float {
      return this@reverse.getInterpolation(input - 1.0F)
    }
  }
}


fun Animator.reverse(): Animator = this.apply {
  interpolator = this.interpolator.reverse()
}
