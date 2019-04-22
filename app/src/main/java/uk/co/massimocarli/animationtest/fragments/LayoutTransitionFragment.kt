package uk.co.massimocarli.animationtest.fragments

import android.animation.AnimatorInflater
import android.animation.LayoutTransition
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_layout_transition.*
import kotlinx.android.synthetic.main.fragment_layout_transition.view.*
import uk.co.massimocarli.animationtest.R
import uk.co.massimocarli.animationtest.util.reverse


class LayoutTransitionFragment : Fragment() {

  private val views: MutableList<View> = mutableListOf()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_layout_transition,
      container,
      false
    ).apply {
      addViewButton.setOnClickListener {
        addView()
      }
      removeViewButton.setOnClickListener {
        removeView()
      }
      addViewButton.isEnabled = true
      removeViewButton.isEnabled = false
      layoutTransitionCheckbox.setOnCheckedChangeListener { _, isChecked ->
        if (isChecked) {
          this.container?.layoutTransition = getLayoutTransition()
        } else {
          this.container?.layoutTransition = null
        }
      }
    }
    return view
  }

  private fun getLayoutTransition() = LayoutTransition().apply {
    enableTransitionType(LayoutTransition.APPEARING)
    val colorAnimator = AnimatorInflater.loadAnimator(
      context,
      R.animator.color_anim
    )
    val colorAnimatorInverse = AnimatorInflater.loadAnimator(
      context,
      R.animator.color_anim
    ).reverse()
    setAnimator(LayoutTransition.APPEARING, colorAnimator);
    setAnimator(LayoutTransition.DISAPPEARING, colorAnimatorInverse);
  }

  private fun addView() {
    val newView = Button(context).apply {
      layoutParams = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
      )
      text = "VIEW ${views.size}"
      views.add(this)
    }
    container.addView(newView, 0)
    removeViewButton.isEnabled = true
  }

  private fun removeView() {
    val viewToRemove = views.removeAt(0)
    container.removeView(viewToRemove)
    removeViewButton.isEnabled = views.size > 0
  }
}