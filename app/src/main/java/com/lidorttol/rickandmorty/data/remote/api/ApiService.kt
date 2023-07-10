package com.lidorttol.rickandmorty.data.remote.api

import com.lidorttol.rickandmorty.data.remote.dto.CharacterDto
import com.lidorttol.rickandmorty.data.remote.dto.CharacterRemoteResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

/*    @GET("character/")
    suspend fun getCharacters(@Query("page") nextPageNumber: Int): CharacterRemoteResponseDto<CharacterDto>*/

    @GET("character/")
    suspend fun getCharacters(): CharacterRemoteResponseDto<CharacterDto>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : CharacterDto

}