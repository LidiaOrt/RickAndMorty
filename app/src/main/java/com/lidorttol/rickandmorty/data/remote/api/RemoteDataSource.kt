package com.lidorttol.rickandmorty.data.remote.api

import com.lidorttol.rickandmorty.data.bo.CharacterBo

interface RemoteDataSource {
    suspend fun getCharacters(): List<CharacterBo>?
}