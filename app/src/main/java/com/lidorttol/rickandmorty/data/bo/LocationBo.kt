package com.lidorttol.rickandmorty.data.bo

data class LocationBo (
  val id: Long,
  val name: String,
  val type: String? = null,
  val dimension: String? = null,
  val residents: List<CharacterBo>? = null,
  val url: String,
  val created: String? = null
)