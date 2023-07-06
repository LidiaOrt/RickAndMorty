package com.lidorttol.rickandmorty.data.bo

data class EpisodeBo(
    val id: Int? = null,
    val name: String? = null,
    val airDate: String? = null,
    val episode: String? = null,
    val characters: ArrayList<CharacterBo>? = null,
    val created: String? = null
)