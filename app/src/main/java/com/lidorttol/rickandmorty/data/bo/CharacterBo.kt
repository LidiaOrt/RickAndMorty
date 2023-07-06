package com.lidorttol.rickandmorty.data.bo

data class CharacterBo(
  val id: Int,
  val name: String? = null,
  val status: String? = null,
  val species: String? = null,
  val type: String? = null,
  val gender: String? = null,
  val origin: OriginBo? = null,
  val location: LocationBo? = null,
  val image: String? = null,
  val episode: ArrayList<String>? = null,
  val url: String? = null,
  val created: String? = null
)