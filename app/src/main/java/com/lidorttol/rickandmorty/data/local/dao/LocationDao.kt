package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lidorttol.rickandmorty.data.local.dbo.episode.EpisodeDbo
import com.lidorttol.rickandmorty.data.local.dbo.location.LocationDbo

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLocation(location: LocationDbo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLocations(locations: List<LocationDbo>)

    @Query("DELETE FROM location")
    fun cleanLocations()

}