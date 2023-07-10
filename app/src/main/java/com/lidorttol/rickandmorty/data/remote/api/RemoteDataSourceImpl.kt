package com.lidorttol.rickandmorty.data.remote.api

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.mapper.dtoToBo
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getCharacters(): List<CharacterBo>? {
        return apiService.getCharacters().result?.map { it.dtoToBo() }
    }

}