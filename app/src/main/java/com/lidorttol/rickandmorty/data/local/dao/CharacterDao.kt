package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("DELETE FROM character")
    fun cleanCharacters()

}