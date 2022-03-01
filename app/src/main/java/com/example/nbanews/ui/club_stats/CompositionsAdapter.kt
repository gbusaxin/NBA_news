package com.example.nbanews.ui.club_stats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.Disposable
import coil.request.ImageRequest
import com.example.nbanews.R
import com.example.nbanews.databinding.ItemCompositionBinding
import com.example.nbanews.domain.Composition

class CompositionsAdapter :
    ListAdapter<Composition, CompositionsAdapter.CompositionViewHolder>(CompositionDiffCallback()) {
    inner class CompositionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCompositionBinding.bind(view)
        val image = binding.imagePlayer
        val name = binding.textViewName
        val country = binding.textViewCountry
        val number = binding.textViewNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompositionViewHolder {
        return CompositionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_composition, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CompositionViewHolder, position: Int) {
        val item = getItem(position)
        var disposable:Disposable?=null
        with(holder){
            name.text = item.playerName
            country.text = item.playerCountry
            number.text = item.playerNumber
            val request = ImageRequest
                .Builder(holder.itemView.context)
                .data(item.playerImage)
                .target{
                    image.setImageDrawable(it)
                }
                .build()
            disposable = holder.itemView.context.imageLoader.enqueue(request)
        }
    }
}