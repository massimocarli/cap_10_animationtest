package uk.co.massimocarli.animationtest

import androidx.fragment.app.Fragment
import uk.co.massimocarli.animationtest.fragments.*

typealias FragmentBuilder = () -> Fragment

data class DemoItem(val name: String, val builder: FragmentBuilder)

val DEMO_MODELS: Array<DemoItem>
  get() = arrayOf(
    DemoItem("Value Animator Example") {
      ValueAnimatorFragment()
    },
    DemoItem("Object Animator Example") {
      ObjectAnimatorFragment()
    },
    DemoItem("Layout Transition Example") {
      LayoutTransitionFragment()
    },
    DemoItem("View State Animation Example") {
      ViewStateAnimationFragment()
    },
    DemoItem("View Property Animator Example") {
      ViewPropertyAnimatorFragment()
    },
    DemoItem("Frame Animation Example") {
      FrameAnimationFragment()
    },
    DemoItem("Scale Layout Animation Example") {
      ScaleLayoutAnimationFragment()
    },
    DemoItem("Rotate Layout Animation Example") {
      RotateLayoutAnimationFragment()
    },
    DemoItem("Translate Layout Animation Example") {
      TraslateLayoutAnimationFragment()
    },
    DemoItem("Alpha Layout Animation Example") {
      AlphaLayoutAnimationFragment()
    },
    DemoItem("Set Layout Animation Example") {
      SetLayoutAnimationFragment()
    },
    DemoItem("Custom Animation Example") {
      CustomAnimationFragment()
    },
    DemoItem("Camera Animation Example") {
      CameraAnimationFragment()
    },
    DemoItem("KeyFrame Animation Example") {
      KeyFrameFragment()
    }
  )