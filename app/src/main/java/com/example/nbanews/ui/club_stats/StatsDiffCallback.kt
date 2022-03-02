package com.example.nbanews.ui.club_stats

import androidx.recyclerview.widget.DiffUtil
import com.example.nbanews.domain.Total

class StatsDiffCallback:DiffUtil.ItemCallback<Total>() {
    override fun areItemsTheSame(oldItem: Total, newItem: Total): Boolean {
        return newItem.season == oldItem.season
    }

    override fun areContentsTheSame(oldItem: Total, newItem: Total): Boolean {
        return newItem == oldItem
    }
}