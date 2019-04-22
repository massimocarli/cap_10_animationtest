package uk.co.massimocarli.animationtest.fragments

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_object_animator.view.*
import uk.co.massimocarli.animationtest.R
import uk.co.massimocarli.animationtest.adapters.ViewSizeAdapter


class ObjectAnimatorFragment : Fragment() {

  private lateinit var mAnimatorSet: AnimatorSet

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.fragment_object_animator,
      container,
      false
    )
    val viewSizeAdapter = ViewSizeAdapter(view.heartView)
    mAnimatorSet = (AnimatorInflater.loadAnimator(activity, R.animator.beating) as AnimatorSet).apply {
      setTarget(viewSizeAdapter)
    }
    return view
  }

  override fun onStart() {
    super.onStart()
    mAnimatorSet.start()
  }
}