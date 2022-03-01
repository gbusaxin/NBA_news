package com.example.nbanews.ui.newsline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemCommentBinding
import com.example.nbanews.domain.Comment

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    inner class CommentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCommentBinding.bind(view)
        val author = binding.textViewCommentAuthor
        val comment = binding.textViewCommentComment
    }

    var list = listOf<Comment>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val item = list[position]
        holder.author.text = item.author
        holder.comment.text = item.comment
    }

    override fun getItemCount(): Int {
        return list.size
    }
}