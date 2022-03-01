package com.example.nbanews.ui.club_stats

import androidx.recyclerview.widget.DiffUtil
import com.example.nbanews.domain.Club

class ClubDiffCallback : DiffUtil.ItemCallback<Club>() {
    override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.club == newItem.club
    }

    override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem == newItem
    }
}