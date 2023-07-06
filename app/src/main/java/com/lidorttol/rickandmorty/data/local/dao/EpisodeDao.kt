package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface EpisodeDao {

    @Query("DELETE FROM episode")
    fun cleanEpisodes()

}