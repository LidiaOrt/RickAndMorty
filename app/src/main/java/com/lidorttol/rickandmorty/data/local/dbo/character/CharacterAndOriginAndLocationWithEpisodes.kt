package com.lidorttol.rickandmorty.data.local.dbo.character

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.rickandmorty.data.local.dbo.episode.EpisodeDbo
import com.lidorttol.rickandmorty.data.local.dbo.location.LocationDbo

data class CharacterAndOriginAndLocationWithEpisodes(
    @Embedded
    val character: CharacterDbo,
    @Relation(
        parentColumn = "originId",
        entityColumn = "locationId"
    )
    val origin: LocationDbo? = null,
    @Relation(
        parentColumn = "characterLocationId",
        entityColumn = "locationId"
    )
    val location: LocationDbo? = null,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "episodeId",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val episodes: List<EpisodeDbo>? = null
)