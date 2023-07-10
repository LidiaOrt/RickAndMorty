package com.lidorttol.rickandmorty.data.local.dbo.character

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterDbo (
  @PrimaryKey
  val characterId: Long,
  val name: String? = null,
  val status: String? = null,
  val species: String? = null,
  val type: String? = null,
  val gender: String? = null,
  val image: String? = null,
  val originId: Long? = null,
  val characterLocationId: Long? = null,
  val url: String,
  val created: String? = null
)