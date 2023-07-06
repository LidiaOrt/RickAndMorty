package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface OriginDao {

    @Query("DELETE FROM origin")
    fun cleanOrigins()

}