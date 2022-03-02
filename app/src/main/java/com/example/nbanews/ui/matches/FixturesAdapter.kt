package com.example.nbanews.ui.matches

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemFixturesBinding
import com.example.nbanews.domain.FutureMatch

class FixturesAdapter(val context: Context) :
    ListAdapter<FutureMatch, FixturesAdapter.FixturesViewHolder>(FixturesDiffCallback()) {

    inner class FixturesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemFixturesBinding.bind(view)
        val team1 = binding.textFutureTeam1
        val image1 = binding.imageFixturesTeam1
        val scores1 = binding.textFutureTeam1Score
        val team2 = binding.textFutureTeam2
        val image2 = binding.imageFixturesTeam2
        val scores2 = binding.textFutureTeam2Score
        val time = binding.textFutureTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        return FixturesViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_fixtures, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            team1.text = item.team1
            scores1.text = item.team1Scores
            team2.text = item.team2
            scores2.text = item.team2Scores
            time.text = item.time
            val request1 = ImageRequest
                .Builder(context)
                .data(item.team1Image)
                .target {
                    image1.setImageDrawable(it)
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
                    image2.setImageDrawable(it)
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
}