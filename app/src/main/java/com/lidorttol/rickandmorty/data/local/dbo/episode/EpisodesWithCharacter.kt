package com.lidorttol.rickandmorty.data.local.dbo.episode

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterDbo
import com.lidorttol.rickandmorty.data.local.dbo.character.CharacterEpisodeCrossRef

data class EpisodesWithCharacter(
    @Embedded val episode: EpisodeDbo,
    @Relation(
        parentColumn = "episodeId",
        entityColumn = "characterId",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val characters: List<CharacterDbo>
)
