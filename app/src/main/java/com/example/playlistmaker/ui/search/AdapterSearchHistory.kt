package com.example.playlistmaker.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import clickDebounce
import com.example.playlistmaker.databinding.TrackrecycleviewItemBinding
import com.example.playlistmaker.domain.models.Track


class AdapterSearchHistory(val onTrackClicked: (Track, Boolean) -> Unit, private val isSearch: Boolean) :
    RecyclerView.Adapter<ViewHolderOfSongs>() {
    var tracks: MutableList<Track> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOfSongs {
        val layoutInspector = LayoutInflater.from(parent.context)
        return ViewHolderOfSongs(
            TrackrecycleviewItemBinding.inflate(
                layoutInspector,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderOfSongs, position: Int) {
        holder.bind(tracks[position])
        holder.itemView.setOnClickListener {
            if (clickDebounce()) {
                onTrackClicked(tracks[position], isSearch)
            }
        }
    }

    override fun getItemCount() = tracks.size

}