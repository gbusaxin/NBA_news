package com.example.nbanews.ui.matches

import androidx.recyclerview.widget.DiffUtil
import com.example.nbanews.domain.ResultMatch

class ResultsDiffCallback : DiffUtil.ItemCallback<ResultMatch>() {
    override fun areItemsTheSame(oldItem: ResultMatch, newItem: ResultMatch) =
        oldItem.team1 == newItem.team1


    override fun areContentsTheSame(oldItem: ResultMatch, newItem: ResultMatch) = oldItem == newItem

}