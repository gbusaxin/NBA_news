package com.example.nbanews.ui.matches

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.imageLoader
import coil.request.ImageRequest
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemResultBinding
import com.example.nbanews.domain.ResultMatch

class ResultsAdapter(val context: Context) :
    ListAdapter<ResultMatch, ResultsAdapter.ResultsViewHolder>(ResultsDiffCallback()) {
    inner class ResultsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemResultBinding.bind(view)
        val team1 = binding.textViewTeam1
        val team2 = binding.textViewTeam2
        val image1 = binding.imageViewTeam1
        val image2 = binding.imageViewTeam2
        val score1 = binding.textViewTeam1Score
        val score2 = binding.textViewTeam2Score
        val result1 = binding.textViewTeam1Result
        val result2 = binding.textViewTeam2Result
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        return ResultsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_result, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            team1.text = item.team1
            team2.text = item.team2
            score1.text = item.team1Score
            score2.text = item.team2Score
            result1.text = item.team1Result
            result2.text = item.team2Result
        }
        val request1 = ImageRequest
            .Builder(context)
            .data(item.team1Image)
            .target {
                holder.image1.setImageDrawable(it)
            }
            .build()
        val imageLoader1 = ImageLoader.Builder(context)
            .componentRegistry {
                add(SvgDecoder(context))
            }
            .build()
            .enqueue(request1)

        val request2 = ImageRequest
            .Builder(context)
            .data(item.team2Image)
            .target {
                holder.image2.setImageDrawable(it)
            }
            .build()
        val imageLoader2 = ImageLoader.Builder(context)
            .componentRegistry {
                add(SvgDecoder(context))
            }
            .build()
            .enqueue(request2)
    }
}

