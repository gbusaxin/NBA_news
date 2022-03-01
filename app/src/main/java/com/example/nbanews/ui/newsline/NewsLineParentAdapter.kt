package com.example.nbanews.ui.newsline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemParentNewslineBinding
import com.example.nbanews.domain.NewsLine
import com.example.nbanews.domain.Publication

class NewsLineParentAdapter(val publicationClickListener: ((Publication) -> Unit)) :
    RecyclerView.Adapter<NewsLineParentAdapter.NewsLineParentViewHolder>() {

    inner class NewsLineParentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemParentNewslineBinding.bind(view)
        val date = binding.textViewNewsLineDate
        val recyclerViewPublications = binding.recyclerViewNewsLinePublications
    }

    var parentList: List<NewsLine> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsLineParentViewHolder {
        return NewsLineParentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_parent_newsline, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsLineParentViewHolder, position: Int) {
        val item = parentList[position]
        holder.date.text = item.date
        holder.recyclerViewPublications.apply {
            val childAdapter = NewsLineChildAdapter(publicationClickListener)
            childAdapter.childList = item.publications
            adapter = childAdapter
        }

    }

    override fun getItemCount(): Int {
        return parentList.size
    }
}