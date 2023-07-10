package com.lidorttol.rickandmorty.data.mapper

import android.util.Log
import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.bo.EpisodeBo
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterAndOriginAndLocationWithEpisodes
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterDbo
import com.lidorttol.rickandmorty.data.local.dbo.location.LocationDbo
import com.lidorttol.rickandmorty.data.remote.dto.CharacterDto


fun CharacterDto.dtoToBo(): CharacterBo = CharacterBo(
    id ?: extractIdFromUrl(url ?: "-1"),
    name,
    status,
    species,
    type,
    gender,
    origin?.dtoToBo(),
    location?.dtoToBo(),
    image,
    episodes?.map {
        EpisodeBo(
            extractIdFromUrl(it),
            url = it
        )
    },
    url ?: "",
    created
)
fun CharacterBo.boToDbo(): CharacterDbo = CharacterDbo(
    id,
    name,
    status,
    species,
    type,
    gender,
    image,
    origin?.id,
    location?.id,
    url,
    created
)

fun CharacterAndOriginAndLocationWithEpisodes.completeDboToBo() = CharacterBo(
    character.characterId,
    character.name,
    character.status,
    character.species,
    character.type,
    character.gender,
    origin?.dboToBo(),
    location?.dboToBo(),
    character.image,
    episodes?.map { it.dboToBo() },
    character.url,
    character.created
)

fun CharacterBo.boToCompleteDbo(): CharacterAndOriginAndLocationWithEpisodes = CharacterAndOriginAndLocationWithEpisodes(
    CharacterDbo(
        id,
        name,
        status,
        species,
        type,
        gender,
        image,
        origin?.url?.let { extractIdFromUrl(it) },
        location?.url?.let { extractIdFromUrl(it) },
        url,
        created
    ),
    origin = origin?.boToDbo(),
    location = location?.boToDbo(),
    episodes = episodes?.map { it.boToDbo() }
)



fun extractIdFromUrl(value: String) = try {
    value.split("/").last().toLong()
} catch (e: Exception) {
    Log.e("Error extracting id from CharacterDto url: -> ", e.toString())
    -1L
}