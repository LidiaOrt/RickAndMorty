package com.lidorttol.rickandmorty.data.local.dbo.episode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episode")
data class EpisodeDbo(
  @PrimaryKey
  @SerializedName("id")
  val episodeId: Int,
  val name: String? = null,
  val airDate: String? = null,
  val episode: String? = null,
  val created: String? = null
)