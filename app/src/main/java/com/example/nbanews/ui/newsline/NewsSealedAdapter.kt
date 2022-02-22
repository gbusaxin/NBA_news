package com.example.nbanews.ui.newsline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemChildNewslineBinding
import com.example.nbanews.databinding.ItemParentNewslineBinding
import com.example.nbanews.domain.SealedNewsLine
import java.lang.Exception

class NewsSealedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected class NewsHeaderAdapter(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemParentNewslineBinding.bind(view)
        val date = binding.textViewNewsLineDate
    }

    protected class NewsBodyAdapter(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemChildNewslineBinding.bind(view)
        val tags = binding.textViewNewslineTags
        val header = binding.textViewNewslineHeader
    }

    var list = listOf<SealedNewsLine>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_HEADER -> return NewsHeaderAdapter(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_parent_newsline, parent, false)
            )
            TYPE_NEWS -> return NewsBodyAdapter(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_child_newsline, parent, false)
            )
            else -> throw Exception("ERROR with view type in NewsSealedAdapter!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when(holder){
            is NewsHeaderAdapter -> holder.date.text = (item as SealedNewsLine.NewsLineS).date
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) = when (list[position]) {
        is SealedNewsLine.NewsLineS -> TYPE_HEADER
        is SealedNewsLine.PublicationS -> TYPE_NEWS
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_NEWS = 1
    }
}