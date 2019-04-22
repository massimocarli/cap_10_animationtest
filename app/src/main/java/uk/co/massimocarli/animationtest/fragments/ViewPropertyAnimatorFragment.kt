package uk.co.massimocarli.animationtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_view_property_animator.view.*
import uk.co.massimocarli.animationtest.R

class ViewPropertyAnimatorFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(
    R.layout.fragment_view_property_animator,
    container,
    false
  ).apply {
    this.viewPropertyAnimatorButton.setOnClickListener {
      animate()
        .x(200F)
        .y(200F)
    }
  }
}