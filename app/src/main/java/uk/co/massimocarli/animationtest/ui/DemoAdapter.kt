package uk.co.massimocarli.animationtest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uk.co.massimocarli.animationtest.DEMO_MODELS

class DemoAdapter(
  val onDemoItemSelected: OnDemoItemSelected? = null
) : RecyclerView.Adapter<DemoViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(android.R.layout.simple_list_item_1, parent, false)
    return DemoViewHolder(view as TextView, onDemoItemSelected)
  }

  override fun getItemCount(): Int = DEMO_MODELS.size

  override fun onBindViewHolder(holder: DemoViewHolder, position: Int) =
    holder.bindModel(DEMO_MODELS[position])
}