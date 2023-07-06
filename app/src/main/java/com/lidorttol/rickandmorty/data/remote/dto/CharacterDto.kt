package com.lidorttol.rickandmorty.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto (
  @SerializedName("id")
  val id: Int,

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
  val origin: OriginDto? = null,

  @SerializedName("location")
  val location: LocationDto? = null,

  @SerializedName("image")
  val image: String? = null,

  @SerializedName("episode")
  val episode: ArrayList<String>? = null,

  @SerializedName("url")
  val url: String? = null,

  @SerializedName("created")
  val created: String? = null
)