package com.lidorttol.rickandmorty.data.repository

import com.lidorttol.rickandmorty.data.bo.CharacterBo
import com.lidorttol.rickandmorty.data.local.LocalDatasource
import com.lidorttol.rickandmorty.data.remote.api.RemoteDataSource
import com.lidorttol.rickandmorty.data.response.CacheableRemoteResponse
import com.lidorttol.rickandmorty.data.response.RepositoryResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class RepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun getCharacters(): RepositoryResponse<List<CharacterBo>?> {
        return object: CacheableRemoteResponse<List<CharacterBo>?>() {
            override suspend fun loadFromLocal(): List<CharacterBo>? {
                return localDatasource.getCharacters()
            }

            override suspend fun requestRemoteCall(): List<CharacterBo>? {
                return remoteDataSource.getCharacters()
            }

            override suspend fun saveRemoteResponse(remoteResponse: List<CharacterBo>?) {
                // localDatasource.saveCharacters(remoteResponse)
            }

            override fun shouldRequestFromRemote(localResponse: List<CharacterBo>?): Boolean {
                // return localResponse.isNullOrEmpty()
                return true
            }

        }.build()
    }

    override suspend fun getCharacterDetail(id: Long): RepositoryResponse<CharacterBo?> {
        return object: CacheableRemoteResponse<CharacterBo?>() {
            override suspend fun loadFromLocal(): CharacterBo? {
                return localDatasource.getCharactersById(id)
            }

            override suspend fun requestRemoteCall(): CharacterBo? {
                return remoteDataSource.getCharacterById(id)
            }

            override suspend fun saveRemoteResponse(remoteResponse: CharacterBo?) {
                // localDatasource.saveCharacters(remoteResponse)
            }

            override fun shouldRequestFromRemote(localResponse: CharacterBo?): Boolean {
                // return localResponse.isNullOrEmpty()
                return true
            }

        }.build()
    }

}