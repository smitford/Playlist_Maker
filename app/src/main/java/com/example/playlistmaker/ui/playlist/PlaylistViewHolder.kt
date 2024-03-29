package com.example.playlistmaker.ui.playlist

import android.util.DisplayMetrics
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.playlistmaker.R
import com.example.playlistmaker.databinding.TrackrecycleviewItemBinding
import com.example.playlistmaker.domain.models.Track
import java.text.SimpleDateFormat
import java.util.Locale

class PlaylistViewHolder(private val binding: TrackrecycleviewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(track: Track) {
        binding.songName.text = track.trackName
        binding.length.text = SimpleDateFormat(
            "mm:ss",
            Locale.getDefault()
        ).format( track.trackTimeMillis.toLong())
        binding.artistName.text = track.artistName

        Glide.with(binding.albumImage)
            .load(track.artworkUrl100)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .transform(RoundedCorners(roundCorner()))
            .into(binding.albumImage)
    }

    private fun roundCorner(): Int = ROUNDING_OF_CORNERS_PX * (itemView.resources
        .displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

    companion object {
        private const val ROUNDING_OF_CORNERS_PX = 2
    }
}