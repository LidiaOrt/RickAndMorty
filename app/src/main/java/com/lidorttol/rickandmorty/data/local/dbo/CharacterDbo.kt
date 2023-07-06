package com.lidorttol.rickandmorty.data.local.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class CharacterDbo (
  @PrimaryKey
  @SerializedName("id")
  val id: Int,
  val name: String? = null,
  val status: String? = null,
  val species: String? = null,
  val type: String? = null,
  val gender: String? = null,
  val origin: OriginDbo? = null,
  val location: LocationDbo? = null,
  val image: String? = null,
  val episode: ArrayList<String>? = null,
  val url: String? = null,
  val created: String? = null
)