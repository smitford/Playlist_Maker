package com.example.playlistmaker.trackRecycleView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.playlistmaker.MediaActivity
import com.example.playlistmaker.PlayerActivity
import com.example.playlistmaker.R

class AdapterSearchHistory (private val tracks: List<Track>) :
RecyclerView.Adapter<ViewHolderOfSongs>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOfSongs {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.trackrecycleview_item, parent, false)
        return ViewHolderOfSongs(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderOfSongs, position: Int) {

        holder.bind(tracks[position])
        holder.itemView.setOnClickListener{

            val displayPlayer = Intent(it.context, PlayerActivity::class.java)
            displayPlayer.putExtra("track", tracks[position])
            it.context.startActivity(displayPlayer)
        }

    }

    override fun getItemCount() = tracks.size
}