package com.lidorttol.rickandmorty.data.response

import com.lidorttol.rickandmorty.data.utils.AsyncResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface RepositoryResponse<out ResultType> {

    suspend fun flow(): Flow<AsyncResult<ResultType>>

}

fun <ResultType> emptyRepositoryResponse(): RepositoryResponse<ResultType> = EmptyRepositoryResponse

private object EmptyRepositoryResponse : RepositoryResponse<Nothing> {
    override suspend fun flow(): Flow<AsyncResult<Nothing>> {
        return emptyFlow()
    }
}
