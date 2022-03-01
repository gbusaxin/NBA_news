package com.example.nbanews.ui.club_stats

import androidx.recyclerview.widget.DiffUtil
import com.example.nbanews.domain.Composition

class CompositionDiffCallback : DiffUtil.ItemCallback<Composition>() {
    override fun areItemsTheSame(oldItem: Composition, newItem: Composition): Boolean {
        return newItem.playerName == newItem.playerName
    }

    override fun areContentsTheSame(oldItem: Composition, newItem: Composition): Boolean {
        return newItem == oldItem
    }

}