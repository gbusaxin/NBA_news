package com.example.nbanews.ui.matches

import androidx.recyclerview.widget.DiffUtil
import com.example.nbanews.domain.FutureMatch

class FixturesDiffCallback:DiffUtil.ItemCallback<FutureMatch>() {
    override fun areItemsTheSame(oldItem: FutureMatch, newItem: FutureMatch): Boolean {
        return oldItem.team1 == newItem.team1
    }

    override fun areContentsTheSame(oldItem: FutureMatch, newItem: FutureMatch): Boolean {
        return oldItem == newItem
    }
}