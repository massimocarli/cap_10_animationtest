package uk.co.massimocarli.animationtest.fragments

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_object_animator.view.*
import uk.co.massimocarli.animationtest.R
import uk.co.massimocarli.animationtest.adapters.ViewSizeAdapter


class KeyFrameFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_keyframe_animator,
      container,
      false
    )
    val viewSizeAdapter = ViewSizeAdapter(view.heartView)
    val kf0 = Keyframe.ofInt(0.0F, 200)
    val kf1 = Keyframe.ofInt(0.25F, 230)
    val kf2 = Keyframe.ofInt(0.5F, 500)
    val kf3 = Keyframe.ofInt(0.75F, 550)
    val kf4 = Keyframe.ofInt(1.0F, 700)
    val pvhScale = PropertyValuesHolder.ofKeyframe("size", kf0, kf1, kf2, kf3, kf4)
    ObjectAnimator.ofPropertyValuesHolder(viewSizeAdapter, pvhScale).apply {
      duration = 5000
      start()
    }
    return view
  }
}