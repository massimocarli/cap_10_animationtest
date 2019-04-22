package uk.co.massimocarli.animationtest.fragments

import kotlinx.android.synthetic.main.fragment_custom_animation.*
import uk.co.massimocarli.animationtest.R
import uk.co.massimocarli.animationtest.animation.CameraAnimation

class CameraAnimationFragment : AbstractLayoutAnimationFragment() {
  override fun getLayoutId(): Int = R.layout.fragment_camera_animation

  override fun onStart() {
    super.onStart()
    animatedView.startAnimation(CameraAnimation())
  }
}