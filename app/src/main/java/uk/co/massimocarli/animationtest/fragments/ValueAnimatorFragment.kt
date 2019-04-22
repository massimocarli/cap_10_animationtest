package uk.co.massimocarli.animationtest.fragments

import android.animation.Animator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_value_animator.view.*
import uk.co.massimocarli.animationtest.R
import java.util.concurrent.atomic.AtomicBoolean


class ValueAnimatorFragment : Fragment() {

  private val running = AtomicBoolean()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(R.layout.fragment_value_animator, container, false).apply {
      this.startButton.setOnClickListener(View.OnClickListener {
        // We get the value for the end value and duration
        val maxValue = endSeekBar.getProgress()
        val duration = durationSeekBar.getProgress().toLong()
        // We show the current startValue
        outputValue.text = "0"
        // We manage the animation
        startAnimation(outputValue, maxValue, duration)
      })
    }


  private fun startAnimation(output: TextView, endValue: Int, durationValue: Long) {
    if (running.get()) {
      // We skip if the animation is running
      return
    }
    ValueAnimator.ofInt(0, endValue).apply {
      // We set the duration of the animation
      duration = durationValue
      addUpdateListener { animation ->
        // The animator gives us the current value
        val value = animation.animatedValue.toString()
        output.text = value
      }
      addListener(object : Animator.AnimatorListener {

        override fun onAnimationCancel(animator: Animator) {
          Toast.makeText(activity, "onAnimationCancel", Toast.LENGTH_SHORT).show()
        }

        override fun onAnimationEnd(animator: Animator) {
          running.set(false)
          Toast.makeText(activity, "onAnimationEnd", Toast.LENGTH_SHORT).show()
        }

        override fun onAnimationRepeat(animator: Animator) {
          Toast.makeText(activity, "onAnimationRepeat", Toast.LENGTH_SHORT).show()
        }

        override fun onAnimationStart(animator: Animator) {
          Toast.makeText(activity, "onAnimationStart", Toast.LENGTH_SHORT).show()
        }

      })
      running.set(true)
      // We start the animator
      start()
    }
  }
}