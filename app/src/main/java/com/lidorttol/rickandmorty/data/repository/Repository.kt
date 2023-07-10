package com.lidorttol.rickandmorty.data.repository

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.response.RepositoryResponse

interface Repository {

    suspend fun getCharacters(): RepositoryResponse<List<CharacterBo>?>

    suspend fun getCharacterDetail(id: Int): RepositoryResponse<CharacterBo>

}