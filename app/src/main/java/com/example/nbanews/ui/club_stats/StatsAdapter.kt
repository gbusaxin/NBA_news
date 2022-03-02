package com.example.nbanews.ui.club_stats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemStatsBinding
import com.example.nbanews.domain.Total

class StatsAdapter : ListAdapter<Total, StatsAdapter.StatsViewHolder>(StatsDiffCallback()) {

    inner class StatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemStatsBinding.bind(view)
        val season = binding.textViewSeason
        val fg = binding.textViewFG
        val g = binding.textViewG
        val off = binding.textViewOFF
        val rpg = binding.textViewRPG
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        return StatsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_stats, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            season.text = item.season
            fg.text = item.fg
            g.text = item.g
            off.text = item.off
            rpg.text = item.rpg
        }
    }
}