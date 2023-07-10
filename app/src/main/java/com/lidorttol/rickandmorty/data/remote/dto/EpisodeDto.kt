package com.lidorttol.rickandmorty.data.remote.dto

import android.util.Log
import com.google.gson.annotations.SerializedName

data class EpisodeDto (
  @SerializedName("id")
  val id: Long? = null,

  @SerializedName("name")
  val name: String? = null,

  @SerializedName("air_date")
  val airDate: String? = null,

  @SerializedName("episode")
  val episode: String? = null,

  @SerializedName("characters")
  val characters: List<String>? = null,

  @SerializedName("url")
  val url: String? = null,

  @SerializedName("created")
  val created: String? = null
) {

  fun extractIdFromUrl() = try {
    url?.split("/")?.last()?.toLong() ?: -1L
  } catch (e: Exception) {
    Log.e("Error extracting id from EpisodeDto url: -> ", e.toString())
    -1L
  }

}