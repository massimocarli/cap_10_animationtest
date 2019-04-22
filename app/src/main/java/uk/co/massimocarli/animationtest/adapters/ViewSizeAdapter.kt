package uk.co.massimocarli.animationtest.adapters

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout

class ViewSizeAdapter(val view: View) {

  fun setSize(size: Int) {
    LinearLayout.LayoutParams(size, size).apply {
      gravity = Gravity.CENTER
      view.layoutParams = this
    }
  }
}