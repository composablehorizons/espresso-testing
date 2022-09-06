package co.composables.espressotesting

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TextViewHolder(val textView: TextView) : ViewHolder(textView)

class TextAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private val _items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            android.R.layout.simple_list_item_1, parent, false
        ) as TextView
        return TextViewHolder(view)
    }


    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.textView.text = _items[position]
    }

    override fun getItemCount(): Int {
        return _items.count()
    }

    fun publish(items: List<String>) {
        _items.clear()
        _items.addAll(items)
    }
}
