package uk.co.massimocarli.animationtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import uk.co.massimocarli.animationtest.R


abstract class AbstractLayoutAnimationFragment : Fragment() {

  companion object {
    private val ELEMENT_DIM = 100
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val data = Array<String>(ELEMENT_DIM) {
      "LABEL #$it"
    }
    return inflater.inflate(
      getLayoutId(),
      container,
      false
    ).apply {
      findViewById<GridView>(R.id.animatedView).apply {
        adapter = ArrayAdapter<String>(
          context,
          android.R.layout.simple_list_item_1, data
        )
      }
    }
  }

  abstract fun getLayoutId(): Int
}