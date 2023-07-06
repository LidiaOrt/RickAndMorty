package com.lidorttol.rickandmorty.data.local.dbo.character

import androidx.room.Entity

@Entity(primaryKeys = ["characterId", "episodeId"])
data class CharacterEpisodeCrossRef(
    val characterId: Int,
    val episodeId: Int
)
