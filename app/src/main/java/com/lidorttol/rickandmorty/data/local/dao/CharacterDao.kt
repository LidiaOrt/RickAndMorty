package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterAndOriginAndLocationWithEpisodes

@Dao
interface CharacterDao {

    @Query("DELETE FROM character")
    fun cleanCharacters()

    @Transaction
    @Query("SELECT * FROM character")
    suspend fun getCharacters(): List<CharacterAndOriginAndLocationWithEpisodes>

}