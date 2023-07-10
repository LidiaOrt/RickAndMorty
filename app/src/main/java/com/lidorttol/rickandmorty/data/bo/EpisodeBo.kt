package com.lidorttol.rickandmorty.data.bo

data class EpisodeBo(
    val id: Long,
    val name: String? = null,
    val airDate: String? = null,
    val episode: String? = null,
    val characters: List<CharacterBo>? = null,
    val url: String,
    val created: String? = null
)