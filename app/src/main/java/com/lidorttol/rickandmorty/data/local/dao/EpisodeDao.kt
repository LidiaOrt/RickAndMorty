package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lidorttol.rickandmorty.data.local.dbo.episode.EpisodeDbo

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEpisode(episode: EpisodeDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEpisodes(episodes: List<EpisodeDbo>)

    @Query("DELETE FROM episode")
    fun cleanEpisodes()

}