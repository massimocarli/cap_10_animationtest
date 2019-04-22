package uk.co.massimocarli.animationtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uk.co.massimocarli.animationtest.R

class ViewStateAnimationFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(
    R.layout.fragment_view_state_animation,
    container,
    false
  )
}

