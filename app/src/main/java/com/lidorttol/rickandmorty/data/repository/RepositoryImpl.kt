package com.lidorttol.rickandmorty.data.repository

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.local.LocalDatasource
import com.lidorttol.rickandmorty.data.remote.api.RemoteDataSource
import com.lidorttol.rickandmorty.data.response.RepositoryResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class RepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun getCharacters(resetDatabase: Boolean): RepositoryResponse<List<CharacterBo>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterDetail(id: Int): RepositoryResponse<CharacterBo> {
        TODO("Not yet implemented")
    }

}