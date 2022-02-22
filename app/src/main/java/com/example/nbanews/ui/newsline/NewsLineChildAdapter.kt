package com.example.nbanews.ui.newsline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemChildNewslineBinding
import com.example.nbanews.domain.Publication

class NewsLineChildAdapter() :
    RecyclerView.Adapter<NewsLineChildAdapter.NewsLineChildViewHolder>() {

    inner class NewsLineChildViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemChildNewslineBinding.bind(view)
        val header = binding.textViewNewslineHeader
        val tags = binding.textViewNewslineTags
    }
    var childList: List<Publication> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var onNewsLineClickListener: ((Publication) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsLineChildViewHolder {
        return NewsLineChildViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_child_newsline,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsLineChildViewHolder, position: Int) {
        val item = childList[position]
        holder.header.text = item.header
        holder.tags.text = item.tags
        holder.itemView.setOnClickListener {
            onNewsLineClickListener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return childList.size
    }
}