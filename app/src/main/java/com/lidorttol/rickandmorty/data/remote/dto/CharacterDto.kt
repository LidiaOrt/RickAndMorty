package com.lidorttol.rickandmorty.data.remote.dto

import android.util.Log
import com.google.gson.annotations.SerializedName

data class CharacterDto (
  @SerializedName("id")
  val id: Long? = null,

  @SerializedName("name")
  val name: String? = null,

  @SerializedName("status")
  val status: String? = null,

  @SerializedName("species")
  val species: String? = null,

  @SerializedName("type")
  val type: String? = null,

  @SerializedName("gender")
  val gender: String? = null,

  @SerializedName("origin")
  val origin: LocationDto? = null,

  @SerializedName("location")
  val location: LocationDto? = null,

  @SerializedName("image")
  val image: String? = null,

  @SerializedName("episode")
  val episodes: List<String>? = null,

  @SerializedName("url")
  val url: String? = null,

  @SerializedName("created")
  val created: String? = null
) {

  fun extractIdFromUrl() = try {
      url?.split("/")?.last()?.toLong() ?: -1L
  } catch (e: Exception) {
    Log.e("Error extracting id from CharacterDto url: -> ", e.toString())
    -1L
  }

}