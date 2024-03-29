package com.example.playlistmaker.domain.use_cases

import com.example.playlistmaker.domain.models.Track
import kotlinx.coroutines.flow.Flow

interface DataBaseTrackInteractor {
    fun getFavoriteTracks(): Flow<List<Track>>
    suspend fun saveFavoriteTrack(track: Track)
    fun isTrackFavorite(trackId: Int): Flow<Boolean>
    suspend fun deleteTrackFromFav(trackId: Int)
    suspend fun saveTrack(track: Track)
}