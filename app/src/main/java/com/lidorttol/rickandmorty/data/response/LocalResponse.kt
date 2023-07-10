package com.lidorttol.rickandmorty.data.response

import com.lidorttol.rickandmorty.data.utils.AsyncResult
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class LocalResponse<ResultType> {

    private var flow: Flow<AsyncResult<ResultType>>? = null

    //region RepositoryResponse
    private val response = object : RepositoryResponse<ResultType> {
        override suspend fun flow() = executeFlow()
    }
    //endregion

    //region Logic Template
    fun build(): RepositoryResponse<ResultType> {
        return response
    }

    private suspend fun executeFlow(): Flow<AsyncResult<ResultType>> {
        return flow ?: flow {
            executeBase { emit(it) }
        }.apply { flow = this }
    }

    private suspend fun executeBase(emit: suspend (AsyncResult<ResultType>) -> Unit): AsyncResult<ResultType> {
        emit(AsyncResult.Loading(null))
        val value = try {
            val dbResult = loadFromLocal()
            AsyncResult.Success(dbResult)
        } catch (e: Exception) {
            AsyncResult.Error(e.message.toString(), null)
        }
        emit(value)
        return value
    }
    //endregion

    //region Abstract methods
    protected abstract suspend fun loadFromLocal(): ResultType?
    //endregion
}
