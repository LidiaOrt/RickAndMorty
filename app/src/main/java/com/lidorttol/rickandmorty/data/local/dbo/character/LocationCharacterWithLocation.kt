package com.lidorttol.rickandmorty.data.local.dbo.character

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.rickandmorty.data.local.dbo.location.LocationDbo

data class LocationWithCharacter(
    @Embedded val location: LocationDbo,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "location"
    )
    val residents: List<CharacterDbo>
)
