package com.lidorttol.rickandmorty.data.remote.dto

import com.google.gson.annotations.SerializedName

data class EpisodeDto (
  @SerializedName("id")
  val id: Int? = null,

  @SerializedName("name")
  val name: String? = null,

  @SerializedName("air_date")
  val airDate: String? = null,

  @SerializedName("episode")
  val episode: String? = null,

  @SerializedName("characters")
  val characters: ArrayList<String>? = null,

  @SerializedName("url")
  val url: String? = null,

  @SerializedName("created")
  val created: String? = null
)