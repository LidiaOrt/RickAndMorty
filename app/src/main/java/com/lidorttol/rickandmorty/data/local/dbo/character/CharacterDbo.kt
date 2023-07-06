package com.lidorttol.rickandmorty.data.local.dbo.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class CharacterDbo (
  @PrimaryKey
  @SerializedName("id")
  val characterId: Int,
  val name: String? = null,
  val status: String? = null,
  val species: String? = null,
  val type: String? = null,
  val gender: String? = null,
  val origin: Int,
  val location: Int,
  val image: String? = null,
  val created: String? = null
)