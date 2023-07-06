package com.lidorttol.rickandmorty.data.remote.api

import com.lidorttol.rickandmorty.data.remote.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/character")
    suspend fun getCharacters() : List<CharacterDto>

    @GET("/character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : CharacterDto

}