package com.lidorttol.rickandmorty.data.local.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episode")
data class EpisodeDbo(
  @PrimaryKey
  @SerializedName("id")
  val id: Int,
  val name: String? = null,
  val airDate: String? = null,
  val episode: String? = null,
  val characters: ArrayList<String>? = null,
  val url: String? = null,
  val created: String? = null
)