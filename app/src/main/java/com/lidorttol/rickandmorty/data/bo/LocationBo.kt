package com.lidorttol.rickandmorty.data.bo

data class LocationBo (
  val id: Int,
  val name: String,
  val type: String? = null,
  val dimension: String? = null,
  val residents: List<CharacterBo>? = null,
  val created: String? = null
)