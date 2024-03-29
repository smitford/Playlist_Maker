package com.example.playlistmaker.ui.media.playlists

import com.example.playlistmaker.domain.models.PlaylistInfo

sealed interface PlaylistCatalogState {
    object Empty : PlaylistCatalogState
    data class LoadedCatalog(val playlists: List<PlaylistInfo>) : PlaylistCatalogState
}