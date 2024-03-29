package com.example.playlistmaker.domain.api

import com.example.playlistmaker.domain.consumer.DaoConsumer
import com.example.playlistmaker.domain.models.Playlist
import com.example.playlistmaker.domain.models.PlaylistInfo
import com.example.playlistmaker.domain.models.Track
import kotlinx.coroutines.flow.Flow

interface DataBasePlaylistRepository {
    fun getPlaylist(playlistPK: Int): Flow<Playlist>

    fun getPlaylistInfo(playlistPK: Int) :Flow<PlaylistInfo>

    fun getPlaylistsInfo(): Flow<DaoConsumer<List<PlaylistInfo>>>

    suspend fun createPlaylist(playlistName: String, playlistDescription: String?, imgUri: String?)

    fun addTrackToPlaylist(playlistPK: Int, trackPK: Int): Flow<Boolean>

    suspend fun deleteTrackFromPlaylist (playlistPK: Int, trackPK: Int)

    suspend fun deletePlaylist(playlistPK: Int)

    suspend fun updatePlaylistInfo(playlistInfo: PlaylistInfo)

}