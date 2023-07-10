package com.lidorttol.rickandmorty.data.mapper

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.bo.LocationBo
import com.lidorttol.rickandmorty.data.local.dbo.location.LocationDbo
import com.lidorttol.rickandmorty.data.remote.dto.LocationDto

fun LocationDto.dtoToBo(): LocationBo = LocationBo(
    id ?: -1,
    name,
    type,
    dimension,
    residents = residents?.map {
        CharacterBo(
            id ?: extractIdFromUrl(),
            url = url ?: ""
        )
    },
    url ?: "",
    created
)

fun LocationBo.boToDbo(): LocationDbo = LocationDbo(
    id,
    name,
    type,
    dimension,
    url,
    created
)

fun LocationDbo.dboToBo(): LocationBo = LocationBo(
    locationId ,
    name,
    type,
    dimension,
    null,
    url,
    created
)