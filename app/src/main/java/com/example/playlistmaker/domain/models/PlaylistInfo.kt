package com.example.playlistmaker.domain.models

data class PlaylistInfo(
    val id: Int,
    val name: String,
    val description: String,
    val tracksNumber: Int
)