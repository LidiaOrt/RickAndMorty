package com.lidorttol.rickandmorty.data.local.dbo.character

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.rickandmorty.data.local.dbo.episode.EpisodeDbo

data class CharacterWithEpisodes(
    @Embedded val character: CharacterDbo,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "episodeId",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val episodes: List<EpisodeDbo>
)
