package uk.co.massimocarli.animationtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.view.*
import uk.co.massimocarli.animationtest.R
import uk.co.massimocarli.animationtest.ui.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

  protected lateinit var navigation: Navigation

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val activityAsNavigation = activity as? Navigation
    if (activityAsNavigation != null) {
      navigation = activityAsNavigation
    } else {
      throw IllegalStateException("Navigation Needed!")
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_main, container, false).apply {
      recyclerView.layoutManager = LinearLayoutManager(activity)
      val dividerItemDecoration = DividerItemDecoration(
        context, DividerItemDecoration.VERTICAL
      )
      recyclerView.addItemDecoration(dividerItemDecoration)
      recyclerView.adapter = DemoAdapter {
        navigation.replaceFragment(it.builder(), it.name)
      }
    }
  }
}
