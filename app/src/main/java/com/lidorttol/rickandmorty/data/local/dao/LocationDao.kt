package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LocationDao {

    @Query("DELETE FROM location")
    fun cleanLocations()

}