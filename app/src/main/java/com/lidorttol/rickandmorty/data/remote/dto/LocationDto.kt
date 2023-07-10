package com.lidorttol.rickandmorty.data.remote.dto

import android.util.Log
import com.google.gson.annotations.SerializedName

data class LocationDto (
  @SerializedName("id")
  val id: Long? = null,

  @SerializedName("name")
  val name: String,

  @SerializedName("type")
  val type: String? = null,

  @SerializedName("dimension")
  val dimension: String? = null,

  @SerializedName("residents")
  val residents: List<String>? = null,

  @SerializedName("url")
  val url: String? = null,

  @SerializedName("created")
  val created: String? = null
) {

  fun extractIdFromUrl() = try {
    url?.split("/")?.last()?.toLong() ?: -1L
  } catch (e: Exception) {
    Log.e("Error extracting id from LocationDto url: -> ", e.toString())
    -1L
  }

}