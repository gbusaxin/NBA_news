package com.example.nbanews.ui.club_stats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemClubBinding
import com.example.nbanews.domain.Club
import de.hdodenhof.circleimageview.CircleImageView

class ClubAdapter : ListAdapter<Club, ClubAdapter.ClubViewHolder>(ClubDiffCallback()) {

    inner class ClubViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemClubBinding.bind(view)
        val club = binding.textViewClub
        val pos = binding.textViewPos
        val wins = binding.textViewWins
        val fails = binding.textViewFails
        val percent = binding.textViewPercent
        val image = binding.circleImageClub
    }

    var onClubClick:((Club) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_club,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        val item = getItem(position)
        with(holder){
            club.text = item.club
            pos.text = item.pos
            wins.text = item.wins
            fails.text = item.fails
            percent.text = item.percent
            image.loadSvg(item.clubImage)
        }
        holder.itemView.setOnClickListener {
            onClubClick?.invoke(item)
        }
    }

    fun ImageView.loadSvg(url: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }
}