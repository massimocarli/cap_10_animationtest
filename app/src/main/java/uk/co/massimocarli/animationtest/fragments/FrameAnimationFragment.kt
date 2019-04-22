package uk.co.massimocarli.animationtest.fragments

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_frame_animation.view.*
import uk.co.massimocarli.animationtest.R


class FrameAnimationFragment : Fragment() {

  private lateinit var animationDrawable: AnimationDrawable

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    inflater.inflate(
      R.layout.fragment_frame_animation,
      container,
      false
    ).apply {
      animationDrawable = animatedTextView.background as AnimationDrawable
    }

  override fun onStart() {
    super.onStart()
    animationDrawable.start()
  }

  override fun onStop() {
    animationDrawable.stop()
    super.onStop()
  }
}