package com.lidorttol.rickandmorty.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LocationDto (
  @SerializedName("name")
  val name: String? = null,

  @SerializedName("url")
  val url: String? = null
)