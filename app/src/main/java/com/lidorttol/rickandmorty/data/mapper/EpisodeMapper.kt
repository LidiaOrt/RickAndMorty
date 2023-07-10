package com.lidorttol.rickandmorty.data.mapper

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.bo.EpisodeBo
import com.lidorttol.rickandmorty.data.local.dbo.episode.EpisodeDbo
import com.lidorttol.rickandmorty.data.remote.dto.EpisodeDto

fun EpisodeDto.dtoToBo(): EpisodeBo = EpisodeBo(
    id ?: -1,
    name,
    airDate,
    episode,
    characters = characters?.map {
        CharacterBo(
            id ?: extractIdFromUrl(),
            url = url ?: ""
        )
    },
    url ?: "",
    created
)

fun EpisodeBo.boToDbo(): EpisodeDbo = EpisodeDbo(
    id,
    name,
    airDate,
    episode,
    url,
    created
)

fun EpisodeDbo.dboToBo(): EpisodeBo = EpisodeBo(
    episodeId,
    name,
    airDate,
    episode,
    null,
    url,
    created
)