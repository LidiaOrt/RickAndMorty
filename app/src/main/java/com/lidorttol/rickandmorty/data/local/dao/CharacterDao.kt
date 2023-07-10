package com.lidorttol.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterAndOriginAndLocationWithEpisodes
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterDbo

@Dao
interface CharacterDao {

    @Query("DELETE FROM character")
    fun cleanCharacters()

    @Transaction
    @Query("SELECT * FROM character")
    suspend fun getCharacters(): List<CharacterAndOriginAndLocationWithEpisodes>

    @Transaction
    @Query("SELECT * FROM character WHERE characterId = :id")
    suspend fun getCharacterById(id: Long): CharacterAndOriginAndLocationWithEpisodes

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(character: CharacterDbo)

    /*@Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(characters: List<CharacterAndOriginAndLocationWithEpisodes>)*/

}