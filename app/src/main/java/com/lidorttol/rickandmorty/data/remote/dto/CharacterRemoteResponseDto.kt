package com.lidorttol.rickandmorty.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterRemoteResponseDto<T>(
    @SerializedName("results")
    val result: List<T>? = null,
    @SerializedName("info")
    val info: InfoDto? = null,
)