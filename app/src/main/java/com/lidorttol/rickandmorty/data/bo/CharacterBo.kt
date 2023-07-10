package com.lidorttol.rickandmorty.data.bo

data class CharacterBo(
  val id: Long,
  val name: String? = null,
  val status: String? = null,
  val species: String? = null,
  val type: String? = null,
  val gender: String? = null,
  val origin: LocationBo? = null,
  val location: LocationBo? = null,
  val image: String? = null,
  val episodes: List<EpisodeBo>? = null,
  val url: String,
  val created: String? = null,
  val totalItems: Int = 0
)