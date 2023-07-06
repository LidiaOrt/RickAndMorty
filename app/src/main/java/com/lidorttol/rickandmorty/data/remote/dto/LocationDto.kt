package com.lidorttol.rickandmorty.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LocationDto (
  @SerializedName("id")
  val id: Int,

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
)